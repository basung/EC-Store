package com.magicDigit.ecStore.wares.goodsTags;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-23-下午2:40
 */

@Entity
@Table(name = "BSS_WARES_GOODS_TAGS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GoodsTags extends GenericEntity {


    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_tags_name")
    private String goodsTagsName;

    @Column(name = "goods_tags_id")
    private String goodsTagsId;

}
