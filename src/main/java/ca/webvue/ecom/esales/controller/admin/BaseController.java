package ca.webvue.ecom.esales.controller.admin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.webvue.ecom.esales.base.DateEditor;
import ca.webvue.ecom.esales.base.Setting;
import ca.webvue.ecom.esales.entity.Log;
import ca.webvue.ecom.esales.message.Message;
import ca.webvue.ecom.esales.template.directive.FlashMessageDirective;
import ca.webvue.ecom.esales.util.SettingUtils;
import ca.webvue.ecom.esales.util.SpringUtils;

public class BaseController {
	/** The view for the errors*/
	protected static final String ERROR_VIEW = "/admin/common/error";

	/** Error message */
	protected static final Message ERROR_MESSAGE = Message.error("admin.message.error");

	/** Success message */
	protected static final Message SUCCESS_MESSAGE = Message.success("admin.message.success");

	/** Constraint violation attribute name */
	private static final String CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";

	@Resource(name = "validator")
	private Validator validator;

	/**
	 * Bind data
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new DateEditor(true));
	}

	/**
	 * Data validation
	 * @param target
	 * @param groups
	 * @return
	 */
	protected boolean isValid(Object target, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
		if (constraintViolations.isEmpty()) {
			return true;
		} else {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
			return false;
		}
	}

	/**
	 * Data validation
	 * @param type
	 * @param property
	 * @param value
	 * @param groups
	 * @return
	 */
	protected boolean isValid(Class<?> type, String property, Object value, Class<?>... groups) {
		Set<?> constraintViolations = validator.validateValue(type, property, value, groups);
		if (constraintViolations.isEmpty()) {
			return true;
		} else {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
			return false;
		}
	}

	/**
	 * Format currency
	 * @param amount
	 * @param showSign
	 * @param showUnit
	 * @return
	 */
	protected String currency(BigDecimal amount, boolean showSign, boolean showUnit) {
		Setting setting = SettingUtils.get();
		String price = setting.setScale(amount).toString();
		if (showSign) {
			price = setting.getCurrencySign() + price;
		}
		if (showUnit) {
			price += setting.getCurrencyUnit();
		}
		return price;
	}

	/**
	 * Get i18n message
	 * @param code
	 * @param args
	 * @return
	 */
	protected String message(String code, Object... args) {
		return SpringUtils.getMessage(code, args);
	}

	/**
	 * Add flash message
	 * @param redirectAttributes
	 * @param message
	 */
	protected void addFlashMessage(RedirectAttributes redirectAttributes, Message message) {
		if (redirectAttributes != null && message != null) {
			redirectAttributes.addFlashAttribute(FlashMessageDirective.FLASH_MESSAGE_ATTRIBUTE_NAME, message);
		}
	}

	/**
	 * Add log
	 * @param content
	 */
	protected void addLog(String content) {
		if (content != null) {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			requestAttributes.setAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME, content, RequestAttributes.SCOPE_REQUEST);
		}
	}
}
