package com.magicDigit.ecStore.wares.goods;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import com.magicDigit.ecStore.wares.attribute.AttributeManager;
import com.magicDigit.ecStore.wares.goodsImage.GoodsImageManager;
import com.magicDigit.ecStore.wares.goodsSku.GoodsSKU;
import com.magicDigit.ecStore.wares.goodsSku.GoodsSKUManager;
import com.magicDigit.ecStore.wares.goodsTags.GoodsTags;
import com.magicDigit.ecStore.wares.goodsTags.GoodsTagsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

import static com.magicDigit.ecStore.base.utils.ToolUtil.isNotEmpty;


/**
 * Date: 2018-10-19-下午12:22
 */

@Transactional
@Service
public class GoodsManagerImpl extends GenericManagerImpl<Goods, String, GlobalException> implements GoodsManager {

    private final static Logger logger = LoggerFactory.getLogger(GoodsManagerImpl.class);

    @Resource
    GoodsDao goodsDao;

    @Autowired
    private GoodsSKUManager goodsSKUManager;

    @Autowired
    private GoodsTagsManager goodsTagsManager;

    @Autowired
    private GoodsImageManager goodsImageManager;

    @Autowired
    private AttributeManager attributeManager;

    protected GenericDao<Goods, String> getDao() {
	  return goodsDao;
    }

    @Transactional
    public Goods createGoods(Goods goods) throws GlobalException {

	  //设置SKU
	  Set<GoodsSKU> goodsSKUList = goods.getGoodsSkuList();
	  goods.setGoodsSkuList(setGoodsSKU(goodsSKUList, goods));

	  //设置Tags
	  Set<GoodsTags> goodsTagsList = goods.getGoodsTagsList();
	  goods.setGoodsTagsList(setGoodsTags(goodsTagsList, goods));
	  return goodsDao.save(goods);
    }

    @Transactional
    public Goods updateGoods(Goods goods) throws GlobalException {

	  String goodsId = goods.getId();

	  // 1、删除相关联的图片
	  goodsImageManager.removeByGoodsId(goodsId);

	  // 2、删除相关联的商品扩展属性
	  attributeManager.removeByGoodsId(goodsId);

	  // 3、删除相关联的tags
	  goodsTagsManager.removeByGoodsId(goodsId);

	  // 4、删除相关联的SKU
	  goodsSKUManager.removeByGoodsId(goodsId);

	  //设置SKU
	  Set<GoodsSKU> goodsSKUList = goods.getGoodsSkuList();
	  goods.setGoodsSkuList(setGoodsSKU(goodsSKUList, goods));

	  //设置Tags
	  Set<GoodsTags> goodsTagsList = goods.getGoodsTagsList();
	  goods.setGoodsTagsList(setGoodsTags(goodsTagsList, goods));

	  return goodsDao.save(goods);
    }

    protected Set<GoodsSKU> setGoodsSKU(Set<GoodsSKU> goodsSKUS, Goods goods) {
	  Set<GoodsSKU> newGoodsSKUList = new HashSet<GoodsSKU>();
	  //当是默认规程时，为商品添加默认SKU
	  if (goods.getSpecType() == 1) {

	      GoodsSKU goodsSKU = new GoodsSKU();

		goodsSKU.setGoodsName(goods.getGoodsName());
		goodsSKU.setBrandId(goods.getBrandId());
		goodsSKU.setBrandName(goods.getBrandName());
		goodsSKU.setCategoryId(goods.getCategoryId());
		goodsSKU.setCategoryName(goods.getCategoryName());

	      goodsSKU.setCostPrice(goods.getCostPrice());
	      goodsSKU.setMarketPrice(goods.getMarketPrice());
	      goodsSKU.setSalePrice(goods.getSalePrice());

	      goodsSKU.setSkuImage(goods.getGoodsDefaultImage());
	      goodsSKU.setSkuName(goods.getGoodsName());
	      goodsSKU.setStockNum(goods.getStockNum());
	      goodsSKU.setProductCode(goods.getGoodsCode());
		goodsSKU.setBarCode(goods.getBarCode());
		goodsSKU.setSkuSpec("默认规格");

		goodsSKU.setCreator(goods.getCreator());
		goodsSKU.setModifier(goods.getModifier());
		goodsSKU.setTenantId(goods.getTenantId());

		newGoodsSKUList.add(goodsSKU);
		return newGoodsSKUList;
	  } else {
		if (isNotEmpty(goodsSKUS)) {
		    //遍历SKU
		    for (GoodsSKU goodsSKU : goodsSKUS) {
			  goodsSKU.setCreator(goods.getCreator());
			  goodsSKU.setModifier(goods.getModifier());
			  goodsSKU.setTenantId(goods.getTenantId());

			  goodsSKU.setGoodsName(goods.getGoodsName());
			  goodsSKU.setBrandId(goods.getBrandId());
			  goodsSKU.setBrandName(goods.getBrandName());
			  goodsSKU.setCategoryId(goods.getCategoryId());
			  goodsSKU.setCategoryName(goods.getCategoryName());

			  newGoodsSKUList.add(goodsSKU);
		    }
		    return newGoodsSKUList;
		} else {
		    throw new GlobalException(400, "设置多规格情况下, SKU 数据不可为空");
		}
	  }
    }

    protected Set<GoodsTags> setGoodsTags(Set<GoodsTags> goodsTagsList, Goods goods) {
	  if (isNotEmpty(goodsTagsList)) {
		//遍历Tags
		Set<GoodsTags> newGoodsTagsList = new HashSet<GoodsTags>();
		for (GoodsTags goodsTags : goodsTagsList) {
		    goodsTags.setCreator(goods.getCreator());
		    goodsTags.setModifier(goods.getModifier());
		    goodsTags.setTenantId(goods.getTenantId());
		    newGoodsTagsList.add(goodsTags);
		}
		return newGoodsTagsList;
	  } else {
		return goodsTagsList;
	  }
    }


}
