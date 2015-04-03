package com.lxh.farmer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.graphics.Bitmap;
/**
 * 	һ��ProductInfo�����Ӧһ����Ʒ��Ϣ
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ��ƷID������
	 */
	private int id;
	/**
	 * ��Ʒ����
	 */
	private String productName;
	/**
	 * ��Ʒ����		
	 */
	private String productCode;
	/**
	 * ǰ̨��ʾʱ��Ʒ���µĹ����	
	 */
	private String titleInfo;
	/**
	 * ��Ʒ״̬��0-������1-�ر�	
	 */
	private int status;
	/**
	 * ��ǰ��Ʒ�Ƿ�ɹ��򡣣���Թ��ﳵ��status==0��isAvailable==true�Ĳ�����Ϊ������0-false, 1-true
	 */
	private int isAvailable;
	/**
	 * ��Ʒ��ͼ��������ʹ�ã�	
	 */
	private Bitmap mianImg;
	/**
	 * ��Ʒ����ͼ���б���ʹ�ã�	
	 */
	private String thumbImgUrl;
	/**
	 * ��Ʒ����ͼ��Url����	
	 */
	private String imgArray;
	/**
	 * ��Ʒ����Id	
	 */
	private int categoryId;
	/**
	 * ��Ʒ����ϸ����	
	 */
	private String intro;
	/**
	 * ��ǩ����	
	 */
	private String taglist;
	/**
	 * ��Ʒ���۵�λ	
	 */
	private String unit;
	/**
	 * ��Ʒ�ۼ�	
	 */
	private double salesPrice;
	/**
	 * PV	
	 */
	private int pageView;
	/**
	 * 0-������Ʒ��1-������Ʒ	
	 */
	private int productTypeId;
	/**
	 * ����Ʒ���Ƿ�Ϊ���Ʒ����������Ϊ���߲ˡ��������Ʒ�������µ�ʱȷ��������Ʒ�� 0-false, 1-true
	 */
	private int isComposite;
	/**
	 * ����Ʒ�����Ʒ������ƷĿId���ϣ�����Աѡ�������Ʒ����Ա���������Ʒֻ����������ϵķ�Χ�ڣ�	
	 */
	private String compositeScopeId;
	/**
	 * ��Ӧ��ƷƷĿId���ɶ�Ӧ���ƷĿ��������������ͳ�ƣ�	
	 */
	private String ProductSpeciesIdInclude;
	/**
	 * �޸ĵ�ʱ��
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
