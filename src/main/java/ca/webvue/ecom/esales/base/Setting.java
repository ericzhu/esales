package ca.webvue.ecom.esales.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Setting implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Water mark position
	 */
	public enum WatermarkPosition {
		no, topLeft, topRight, center, bottomLeft, bottomRight
	}

	/**
	 * Number precision round type
	 */
	public enum RoundType {
		roundHalfUp, roundUp, roundDown
	}

	/** Senarios where Captcha is required */
	public enum CaptchaType {

		/** Member login */
		memberLogin,

		/** Member registration */
		memberRegister,

		/** Login on administration */
		adminLogin,

		/** Write a product review */
		review,

		/** Write a product consultation */
		consultation,

		/** Find password */
		findPassword,

		/** Reset password */
		resetPassword,

		/** Other senarios */
		other
	}

	public enum AccountLockType {

		/** Member */
		member,

		/** Administration */
		admin
	}

	/**
	 * Stock allocation timing
	 */
	public enum StockAllocationTime {

		/** Upon placing order */
		order,

		/** Upon payment is done */
		payment,

		/** Upon shipping */
		ship
	}

	/** Authorities about who can write an review */
	public enum ReviewAuthority {

		/** no authority required */
		anyone,

		/** only registered member */
		member,

		/** only the member who has purchased this product */
		purchased
	}

	/** Authorities abot who can consult the status of a product */
	public enum ConsultationAuthority {

		/** No authority required */
		anyone,

		/** Only registered memeber */
		member
	}

	/**
	 * Cache name of this object in EHCache
	 */
	public static final String CACHE_NAME = "setting";

	/**
	 * Cache key of this object in EHCache
	 */
	public static final Integer CACHE_KEY = 0;

	/** Separator */
	private static final String SEPARATOR = ",";

	/** Site name */
	private String siteName;

	/** URL of the site */
	private String siteUrl;

	/** logo */
	private String logo;

	/** Hot search keywords */
	private String hotSearch;

	/** Contact address */
	private String address;

	/** Contact phone */
	private String phone;

	/** Zip code */
	private String zipCode;

	/** E-mail */
	private String email;

	/** Government registration number and text */
	private String certtext;

	/** If the site is enabled */
	private Boolean isSiteEnabled;

	/** Message for the temporary shutdown of the site */
	private String siteCloseMessage;

	/** Width of the product's large image */
	private Integer largeProductImageWidth;

	/** Height of the product's large image */
	private Integer largeProductImageHeight;

	/** Width of the product's medium image */
	private Integer mediumProductImageWidth;

	/** Height of the product's medium image */
	private Integer mediumProductImageHeight;

	/** Width of the product's thumbnail image */
	private Integer thumbnailProductImageWidth;

	/** Height of the product's thumbnail image */
	private Integer thumbnailProductImageHeight;

	/** Default product large image **/
	private String defaultLargeProductImage;

	/** Default product medium image */
	private String defaultMediumProductImage;

	/** Default product thumbnail image */
	private String defaultThumbnailProductImage;

	/** Transparency level of the water mark */
	private Integer watermarkAlpha;

	/** Water mark image */
	private String watermarkImage;

	/** Water mark position */
	private WatermarkPosition watermarkPosition;

	/** Price scale of the product */
	private Integer priceScale;

	/** Price round type */
	private RoundType priceRoundType;

	/** Whether show market price */
	private Boolean isShowMarketPrice;

	/** Default market price convert scale */
	private Double defaultMarketPriceScale;

	/** Open for registration */
	private Boolean isRegisterEnabled;

	/** Allow multiple registration with the same email account */
	private Boolean isDuplicateEmail;

	/** Disabled username */
	private String disabledUsername;

	/** The minimum length of username */
	private Integer usernameMinLength;

	/** The maximum length of username */
	private Integer usernameMaxLength;

	/** The minimum length of password */
	private Integer passwordMinLength;

	/** The maximum length of password */
	private Integer passwordMaxLength;

	/** Initial points upon registration */
	private Long registerPoint;

	/** Policy of agreement of registration */
	private String registerAgreement;

	/** Allow login with email account */
	private Boolean isEmailLogin;

	/** Senarios where captcha is required */
	private CaptchaType[] captchaTypes;

	/** Account types to be locked */
	private AccountLockType[] accountLockTypes;

	/** Maximum number of try before lock the account */
	private Integer accountLockCount;

	/** Account lock expiration time */
	private Integer accountLockTime;

	/** The safe key expiration time */
	private Integer safeKeyExpiryTime;

	/** The maximum size of the uploaded files */
	private Integer uploadMaxSize;

	/** Acceptable file extension */
	private String uploadImageExtension;

	/** Acceptable file extension for flash files */
	private String uploadFlashExtension;

	/** Acceptable file extensions for media files */
	private String uploadMediaExtension;

	/** Acceptable file extension for uploaded files */
	private String uploadFileExtension;

	/** Image upload path */
	private String imageUploadPath;

	/** Flash upload path */
	private String flashUploadPath;

	/** Media file upload path */
	private String mediaUploadPath;

	/** File upload path */
	private String fileUploadPath;

	/** SMTP account of the email sender */
	private String smtpFromMail;

	/** SMTP server host */
	private String smtpHost;

	/** SMTP server port */
	private Integer smtpPort;

	/** SMTP username */
	private String smtpUsername;

	/** SMTP password */
	private String smtpPassword;

	/** Currency symbol */
	private String currencySign;

	/** Currency unit */
	private String currencyUnit;

	/** Alert of the minimum stock level */
	private Integer stockAlertCount;

	/** Stock adjustment timing */
	private StockAllocationTime stockAllocationTime;

	/** Conversion scale of purchase to points */
	private Double defaultPointScale;

	/** Whether development mode enabled */
	private Boolean isDevelopmentEnabled;

	/** Whether allow product reviews */
	private Boolean isReviewEnabled;

	/** If the review requires sanction */
	private Boolean isReviewCheck;

	/** Review authorities */
	private ReviewAuthority reviewAuthority;

	/** Whether consultation enabled */
	private Boolean isConsultationEnabled;

	/** If the sonsulation requires sanction */
	private Boolean isConsultationCheck;

	/** Authorities of consulation */
	private ConsultationAuthority consultationAuthority;

	/** Enable invoice functionalities */
	private Boolean isInvoiceEnabled;

	/** If the the displayed price includes tax */
	private Boolean isTaxPriceEnabled;

	/** Tax rate */
	private Double taxRate;

	/** Cookie path */
	private String cookiePath;

	/** Cookie domain */
	private String cookieDomain;

	/** Kuaidi 100 authorization KEY */
	private String kuaidi100Key;

	/** Enable CNZZ statistics */
	private Boolean isCnzzEnabled;

	/** CNZZ ID */
	private String cnzzSiteId;

	/** CNZZ password */
	private String cnzzPassword;

	@NotEmpty
	@Length(max = 200)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = StringUtils.removeEnd(siteUrl, "/");
	}

	@NotEmpty
	@Length(max = 200)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Length(max = 200)
	public String getHotSearch() {
		return hotSearch;
	}

	public void setHotSearch(String hotSearch) {
		if (hotSearch != null) {
			hotSearch = hotSearch.replaceAll("[,\\s]*,[,\\s]*", ",")
					.replaceAll("^,|,$", "");
		}
		this.hotSearch = hotSearch;
	}

	@Length(max = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(max = 200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(max = 200)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Email
	@Length(max = 200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(max = 200)
	public String getCerttext() {
		return certtext;
	}

	public void setCerttext(String certtext) {
		this.certtext = certtext;
	}

	@NotNull
	public Boolean getIsSiteEnabled() {
		return isSiteEnabled;
	}

	public void setIsSiteEnabled(Boolean isSiteEnabled) {
		this.isSiteEnabled = isSiteEnabled;
	}

	@NotEmpty
	public String getSiteCloseMessage() {
		return siteCloseMessage;
	}

	public void setSiteCloseMessage(String siteCloseMessage) {
		this.siteCloseMessage = siteCloseMessage;
	}

	@NotNull
	@Min(1)
	public Integer getLargeProductImageWidth() {
		return largeProductImageWidth;
	}

	public void setLargeProductImageWidth(Integer largeProductImageWidth) {
		this.largeProductImageWidth = largeProductImageWidth;
	}

	@NotNull
	@Min(1)
	public Integer getLargeProductImageHeight() {
		return largeProductImageHeight;
	}

	public void setLargeProductImageHeight(Integer largeProductImageHeight) {
		this.largeProductImageHeight = largeProductImageHeight;
	}

	@NotNull
	@Min(1)
	public Integer getMediumProductImageWidth() {
		return mediumProductImageWidth;
	}

	public void setMediumProductImageWidth(Integer mediumProductImageWidth) {
		this.mediumProductImageWidth = mediumProductImageWidth;
	}

	@NotNull
	@Min(1)
	public Integer getMediumProductImageHeight() {
		return mediumProductImageHeight;
	}

	public void setMediumProductImageHeight(Integer mediumProductImageHeight) {
		this.mediumProductImageHeight = mediumProductImageHeight;
	}

	@NotNull
	@Min(1)
	public Integer getThumbnailProductImageWidth() {
		return thumbnailProductImageWidth;
	}

	public void setThumbnailProductImageWidth(Integer thumbnailProductImageWidth) {
		this.thumbnailProductImageWidth = thumbnailProductImageWidth;
	}

	@NotNull
	@Min(1)
	public Integer getThumbnailProductImageHeight() {
		return thumbnailProductImageHeight;
	}

	public void setThumbnailProductImageHeight(
			Integer thumbnailProductImageHeight) {
		this.thumbnailProductImageHeight = thumbnailProductImageHeight;
	}

	@NotEmpty
	@Length(max = 200)
	public String getDefaultLargeProductImage() {
		return defaultLargeProductImage;
	}

	public void setDefaultLargeProductImage(String defaultLargeProductImage) {
		this.defaultLargeProductImage = defaultLargeProductImage;
	}

	@NotEmpty
	@Length(max = 200)
	public String getDefaultMediumProductImage() {
		return defaultMediumProductImage;
	}

	public void setDefaultMediumProductImage(String defaultMediumProductImage) {
		this.defaultMediumProductImage = defaultMediumProductImage;
	}

	@NotEmpty
	@Length(max = 200)
	public String getDefaultThumbnailProductImage() {
		return defaultThumbnailProductImage;
	}

	public void setDefaultThumbnailProductImage(
			String defaultThumbnailProductImage) {
		this.defaultThumbnailProductImage = defaultThumbnailProductImage;
	}

	@NotNull
	@Min(0)
	@Max(100)
	public Integer getWatermarkAlpha() {
		return watermarkAlpha;
	}

	public void setWatermarkAlpha(Integer watermarkAlpha) {
		this.watermarkAlpha = watermarkAlpha;
	}

	public String getWatermarkImage() {
		return watermarkImage;
	}

	public void setWatermarkImage(String watermarkImage) {
		this.watermarkImage = watermarkImage;
	}

	@NotNull
	public WatermarkPosition getWatermarkPosition() {
		return watermarkPosition;
	}

	public void setWatermarkPosition(WatermarkPosition watermarkPosition) {
		this.watermarkPosition = watermarkPosition;
	}

	@NotNull
	@Min(0)
	@Max(3)
	public Integer getPriceScale() {
		return priceScale;
	}

	public void setPriceScale(Integer priceScale) {
		this.priceScale = priceScale;
	}

	@NotNull
	public RoundType getPriceRoundType() {
		return priceRoundType;
	}

	public void setPriceRoundType(RoundType priceRoundType) {
		this.priceRoundType = priceRoundType;
	}

	@NotNull
	public Boolean getIsShowMarketPrice() {
		return isShowMarketPrice;
	}

	public void setIsShowMarketPrice(Boolean isShowMarketPrice) {
		this.isShowMarketPrice = isShowMarketPrice;
	}

	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 3)
	public Double getDefaultMarketPriceScale() {
		return defaultMarketPriceScale;
	}

	public void setDefaultMarketPriceScale(Double defaultMarketPriceScale) {
		this.defaultMarketPriceScale = defaultMarketPriceScale;
	}

	@NotNull
	public Boolean getIsRegisterEnabled() {
		return isRegisterEnabled;
	}

	public void setIsRegisterEnabled(Boolean isRegisterEnabled) {
		this.isRegisterEnabled = isRegisterEnabled;
	}

	@NotNull
	public Boolean getIsDuplicateEmail() {
		return isDuplicateEmail;
	}

	public void setIsDuplicateEmail(Boolean isDuplicateEmail) {
		this.isDuplicateEmail = isDuplicateEmail;
	}

	@Length(max = 200)
	public String getDisabledUsername() {
		return disabledUsername;
	}

	public void setDisabledUsername(String disabledUsername) {
		if (disabledUsername != null) {
			disabledUsername = disabledUsername.replaceAll("[,\\s]*,[,\\s]*",
					",").replaceAll("^,|,$", "");
		}
		this.disabledUsername = disabledUsername;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getUsernameMinLength() {
		return usernameMinLength;
	}

	public void setUsernameMinLength(Integer usernameMinLength) {
		this.usernameMinLength = usernameMinLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getUsernameMaxLength() {
		return usernameMaxLength;
	}

	public void setUsernameMaxLength(Integer usernameMaxLength) {
		this.usernameMaxLength = usernameMaxLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getPasswordMinLength() {
		return passwordMinLength;
	}

	public void setPasswordMinLength(Integer passwordMinLength) {
		this.passwordMinLength = passwordMinLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getPasswordMaxLength() {
		return passwordMaxLength;
	}

	public void setPasswordMaxLength(Integer passwordMaxLength) {
		this.passwordMaxLength = passwordMaxLength;
	}

	@NotNull
	@Min(0)
	public Long getRegisterPoint() {
		return registerPoint;
	}

	public void setRegisterPoint(Long registerPoint) {
		this.registerPoint = registerPoint;
	}

	@NotEmpty
	public String getRegisterAgreement() {
		return registerAgreement;
	}

	public void setRegisterAgreement(String registerAgreement) {
		this.registerAgreement = registerAgreement;
	}

	@NotNull
	public Boolean getIsEmailLogin() {
		return isEmailLogin;
	}

	public void setIsEmailLogin(Boolean isEmailLogin) {
		this.isEmailLogin = isEmailLogin;
	}

	public CaptchaType[] getCaptchaTypes() {
		return captchaTypes;
	}

	public void setCaptchaTypes(CaptchaType[] captchaTypes) {
		this.captchaTypes = captchaTypes;
	}

	public AccountLockType[] getAccountLockTypes() {
		return accountLockTypes;
	}

	public void setAccountLockTypes(AccountLockType[] accountLockTypes) {
		this.accountLockTypes = accountLockTypes;
	}

	@NotNull
	@Min(1)
	public Integer getAccountLockCount() {
		return accountLockCount;
	}

	public void setAccountLockCount(Integer accountLockCount) {
		this.accountLockCount = accountLockCount;
	}

	@NotNull
	@Min(0)
	public Integer getAccountLockTime() {
		return accountLockTime;
	}

	public void setAccountLockTime(Integer accountLockTime) {
		this.accountLockTime = accountLockTime;
	}

	@NotNull
	@Min(0)
	public Integer getSafeKeyExpiryTime() {
		return safeKeyExpiryTime;
	}

	public void setSafeKeyExpiryTime(Integer safeKeyExpiryTime) {
		this.safeKeyExpiryTime = safeKeyExpiryTime;
	}

	@NotNull
	@Min(0)
	public Integer getUploadMaxSize() {
		return uploadMaxSize;
	}

	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}

	@Length(max = 200)
	public String getUploadImageExtension() {
		return uploadImageExtension;
	}

	public void setUploadImageExtension(String uploadImageExtension) {
		if (uploadImageExtension != null) {
			uploadImageExtension = uploadImageExtension
					.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "")
					.toLowerCase();
		}
		this.uploadImageExtension = uploadImageExtension;
	}

	@Length(max = 200)
	public String getUploadFlashExtension() {
		return uploadFlashExtension;
	}

	public void setUploadFlashExtension(String uploadFlashExtension) {
		if (uploadFlashExtension != null) {
			uploadFlashExtension = uploadFlashExtension
					.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "")
					.toLowerCase();
		}
		this.uploadFlashExtension = uploadFlashExtension;
	}

	@Length(max = 200)
	public String getUploadMediaExtension() {
		return uploadMediaExtension;
	}

	public void setUploadMediaExtension(String uploadMediaExtension) {
		if (uploadMediaExtension != null) {
			uploadMediaExtension = uploadMediaExtension
					.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "")
					.toLowerCase();
		}
		this.uploadMediaExtension = uploadMediaExtension;
	}

	@Length(max = 200)
	public String getUploadFileExtension() {
		return uploadFileExtension;
	}

	public void setUploadFileExtension(String uploadFileExtension) {
		if (uploadFileExtension != null) {
			uploadFileExtension = uploadFileExtension
					.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "")
					.toLowerCase();
		}
		this.uploadFileExtension = uploadFileExtension;
	}

	@NotEmpty
	@Length(max = 200)
	public String getImageUploadPath() {
		return imageUploadPath;
	}

	public void setImageUploadPath(String imageUploadPath) {
		if (imageUploadPath != null) {
			if (!imageUploadPath.startsWith("/")) {
				imageUploadPath = "/" + imageUploadPath;
			}
			if (!imageUploadPath.endsWith("/")) {
				imageUploadPath += "/";
			}
		}
		this.imageUploadPath = imageUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getFlashUploadPath() {
		return flashUploadPath;
	}

	public void setFlashUploadPath(String flashUploadPath) {
		if (flashUploadPath != null) {
			if (!flashUploadPath.startsWith("/")) {
				flashUploadPath = "/" + flashUploadPath;
			}
			if (!flashUploadPath.endsWith("/")) {
				flashUploadPath += "/";
			}
		}
		this.flashUploadPath = flashUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getMediaUploadPath() {
		return mediaUploadPath;
	}

	public void setMediaUploadPath(String mediaUploadPath) {
		if (mediaUploadPath != null) {
			if (!mediaUploadPath.startsWith("/")) {
				mediaUploadPath = "/" + mediaUploadPath;
			}
			if (!mediaUploadPath.endsWith("/")) {
				mediaUploadPath += "/";
			}
		}
		this.mediaUploadPath = mediaUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		if (fileUploadPath != null) {
			if (!fileUploadPath.startsWith("/")) {
				fileUploadPath = "/" + fileUploadPath;
			}
			if (!fileUploadPath.endsWith("/")) {
				fileUploadPath += "/";
			}
		}
		this.fileUploadPath = fileUploadPath;
	}

	@NotEmpty
	@Email
	@Length(max = 200)
	public String getSmtpFromMail() {
		return smtpFromMail;
	}

	public void setSmtpFromMail(String smtpFromMail) {
		this.smtpFromMail = smtpFromMail;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	@NotNull
	@Min(0)
	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSmtpUsername() {
		return smtpUsername;
	}

	public void setSmtpUsername(String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}

	@Length(max = 200)
	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCurrencySign() {
		return currencySign;
	}

	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	@NotNull
	@Min(0)
	public Integer getStockAlertCount() {
		return stockAlertCount;
	}

	public void setStockAlertCount(Integer stockAlertCount) {
		this.stockAlertCount = stockAlertCount;
	}

	@NotNull
	public StockAllocationTime getStockAllocationTime() {
		return stockAllocationTime;
	}

	public void setStockAllocationTime(StockAllocationTime stockAllocationTime) {
		this.stockAllocationTime = stockAllocationTime;
	}

	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 3)
	public Double getDefaultPointScale() {
		return defaultPointScale;
	}

	public void setDefaultPointScale(Double defaultPointScale) {
		this.defaultPointScale = defaultPointScale;
	}

	@NotNull
	public Boolean getIsDevelopmentEnabled() {
		return isDevelopmentEnabled;
	}

	public void setIsDevelopmentEnabled(Boolean isDevelopmentEnabled) {
		this.isDevelopmentEnabled = isDevelopmentEnabled;
	}

	@NotNull
	public Boolean getIsReviewEnabled() {
		return isReviewEnabled;
	}

	public void setIsReviewEnabled(Boolean isReviewEnabled) {
		this.isReviewEnabled = isReviewEnabled;
	}

	@NotNull
	public Boolean getIsReviewCheck() {
		return isReviewCheck;
	}

	public void setIsReviewCheck(Boolean isReviewCheck) {
		this.isReviewCheck = isReviewCheck;
	}

	@NotNull
	public ReviewAuthority getReviewAuthority() {
		return reviewAuthority;
	}

	public void setReviewAuthority(ReviewAuthority reviewAuthority) {
		this.reviewAuthority = reviewAuthority;
	}

	@NotNull
	public Boolean getIsConsultationEnabled() {
		return isConsultationEnabled;
	}

	public void setIsConsultationEnabled(Boolean isConsultationEnabled) {
		this.isConsultationEnabled = isConsultationEnabled;
	}

	@NotNull
	public Boolean getIsConsultationCheck() {
		return isConsultationCheck;
	}

	public void setIsConsultationCheck(Boolean isConsultationCheck) {
		this.isConsultationCheck = isConsultationCheck;
	}

	@NotNull
	public ConsultationAuthority getConsultationAuthority() {
		return consultationAuthority;
	}

	public void setConsultationAuthority(
			ConsultationAuthority consultationAuthority) {
		this.consultationAuthority = consultationAuthority;
	}

	@NotNull
	public Boolean getIsInvoiceEnabled() {
		return isInvoiceEnabled;
	}

	public void setIsInvoiceEnabled(Boolean isInvoiceEnabled) {
		this.isInvoiceEnabled = isInvoiceEnabled;
	}

	@NotNull
	public Boolean getIsTaxPriceEnabled() {
		return isTaxPriceEnabled;
	}

	public void setIsTaxPriceEnabled(Boolean isTaxPriceEnabled) {
		this.isTaxPriceEnabled = isTaxPriceEnabled;
	}

	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 3)
	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCookiePath() {
		return cookiePath;
	}

	public void setCookiePath(String cookiePath) {
		if (cookiePath != null && !cookiePath.endsWith("/")) {
			cookiePath += "/";
		}
		this.cookiePath = cookiePath;
	}

	@Length(max = 200)
	public String getCookieDomain() {
		return cookieDomain;
	}

	public void setCookieDomain(String cookieDomain) {
		this.cookieDomain = cookieDomain;
	}

	@Length(max = 200)
	public String getKuaidi100Key() {
		return kuaidi100Key;
	}

	public void setKuaidi100Key(String kuaidi100Key) {
		this.kuaidi100Key = kuaidi100Key;
	}

	public Boolean getIsCnzzEnabled() {
		return isCnzzEnabled;
	}

	public void setIsCnzzEnabled(Boolean isCnzzEnabled) {
		this.isCnzzEnabled = isCnzzEnabled;
	}

	public String getCnzzSiteId() {
		return cnzzSiteId;
	}

	public void setCnzzSiteId(String cnzzSiteId) {
		this.cnzzSiteId = cnzzSiteId;
	}

	public String getCnzzPassword() {
		return cnzzPassword;
	}

	public void setCnzzPassword(String cnzzPassword) {
		this.cnzzPassword = cnzzPassword;
	}

	public String[] getHotSearches() {
		return StringUtils.split(hotSearch, SEPARATOR);
	}

	public String[] getDisabledUsernames() {
		return StringUtils.split(disabledUsername, SEPARATOR);
	}

	public String[] getUploadImageExtensions() {
		return StringUtils.split(uploadImageExtension, SEPARATOR);
	}

	public String[] getUploadFlashExtensions() {
		return StringUtils.split(uploadFlashExtension, SEPARATOR);
	}

	public String[] getUploadMediaExtensions() {
		return StringUtils.split(uploadMediaExtension, SEPARATOR);
	}

	public String[] getUploadFileExtensions() {
		return StringUtils.split(uploadFileExtension, SEPARATOR);
	}

	public BigDecimal setScale(BigDecimal amount) {
		if (amount == null) {
			return null;
		}
		int roundingMode;
		if (getPriceRoundType() == RoundType.roundUp) {
			roundingMode = BigDecimal.ROUND_UP;
		} else if (getPriceRoundType() == RoundType.roundDown) {
			roundingMode = BigDecimal.ROUND_DOWN;
		} else {
			roundingMode = BigDecimal.ROUND_HALF_UP;
		}
		return amount.setScale(getPriceScale(), roundingMode);
	}
}
