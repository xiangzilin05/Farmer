package com.lxh.farmer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.graphics.Bitmap;
/**
 * 	一个ProductInfo对象对应一个产品信息
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商品ID，自增
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品编码		
	 */
	private String productCode;
	/**
	 * 前台显示时，品名下的广告语	
	 */
	private String titleInfo;
	/**
	 * 商品状态，0-正常，1-关闭	
	 */
	private int status;
	/**
	 * 当前商品是否可购买。（针对购物车，status==0且isAvailable==true的才能作为订单）0-false, 1-true
	 */
	private int isAvailable;
	/**
	 * 商品主图（详情中使用）	
	 */
	private Bitmap mianImg;
	/**
	 * 商品缩略图（列表中使用）	
	 */
	private String thumbImgUrl;
	/**
	 * 商品多张图的Url数组	
	 */
	private String imgArray;
	/**
	 * 商品分类Id	
	 */
	private int categoryId;
	/**
	 * 商品的详细介绍	
	 */
	private String intro;
	/**
	 * 标签数组	
	 */
	private String taglist;
	/**
	 * 商品销售单位	
	 */
	private String unit;
	/**
	 * 商品售价	
	 */
	private double salesPrice;
	/**
	 * PV	
	 */
	private int pageView;
	/**
	 * 0-零售商品，1-配送商品	
	 */
	private int productTypeId;
	/**
	 * 配送品：是否为组合品（如配送项为“蔬菜”）。组合品必须在下单时确定包含商品项 0-false, 1-true
	 */
	private int isComposite;
	/**
	 * 配送品：组合品包含的品目Id集合（供会员选择例外产品，会员设置例外产品只能在这个集合的范围内）	
	 */
	private String compositeScopeId;
	/**
	 * 对应商品品目Id（可对应多个品目。用于销量或库存统计）	
	 */
	private String ProductSpeciesIdInclude;
	/**
	 * 修改的时间
	 */
	private String modifiedOn;

	@Override
	public String toString() {
		return "productInfo [id=" + id +
				", productName=" + productName
				+ ", productCode=" + productCode +
				", TitleInfo=" + titleInfo
				+ ", status=" + status +
				", available=" + isAvailable
				+ ", mianImg=" + mianImg + 
				", ThumbImg=" + thumbImgUrl
				+ ", imgArray=" + imgArray + 
				", categoryId=" + categoryId
				+ ", intro=" + intro + 
				", taglist=" + taglist + 
				", unit=" + unit + 
				", salesPrice=" + salesPrice + 
				", pageView=" + pageView + 
				", productTypeId=" + productTypeId + 
				", composite=" + isComposite + 
				", compositeScopeId=" + compositeScopeId + 
				", ProductSpeciesIdInclude=" + ProductSpeciesIdInclude + 
				", modifiedOn=" + modifiedOn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getTitleInfo() {
		return titleInfo;
	}

	public void setTitleInfo(String titleInfo) {
		titleInfo = titleInfo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int isAvailable() {
		return isAvailable;
	}

	public void setAvailable(int available) {
		this.isAvailable = available;
	}

	public Bitmap getMianImg() {
		return mianImg;
	}

	public void setMianImg(Bitmap mianImg) {
		this.mianImg = mianImg;
	}

	public String getThumbImg() {
		return thumbImgUrl;
	}

	public void setThumbImg(String thumbImgUrl) {
		this.thumbImgUrl = thumbImgUrl;
	}

	public String getImgArray() {
		return imgArray;
	}

	public void setImgArray(String imgArray) {
		this.imgArray = imgArray;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTaglist() {
		return taglist;
	}

	public void setTaglist(String taglist) {
		this.taglist = taglist;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getPageView() {
		return pageView;
	}

	public void setPageView(int pageView) {
		this.pageView = pageView;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public int isComposite() {
		return isComposite;
	}

	public void setComposite(int composite) {
		this.isComposite = composite;
	}

	public String getCompositeScopeId() {
		return compositeScopeId;
	}

	public void setCompositeScopeId(String compositeScopeId) {
		this.compositeScopeId = compositeScopeId;
	}

	public String getProductSpeciesIdInclude() {
		return ProductSpeciesIdInclude;
	}

	public void setProductSpeciesIdInclude(String productSpeciesIdInclude) {
		ProductSpeciesIdInclude = productSpeciesIdInclude;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	
}
