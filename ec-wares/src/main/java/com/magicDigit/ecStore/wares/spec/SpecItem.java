package com.magicDigit.ecStore.wares.spec;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-19-上午10:49
 */

@Entity
@Table(name = "BSS_WARES_SPEC_ITEM")
@Data
@EntityListeners(AuditingEntityListener.class)
public class SpecItem extends GenericEntity {

    /**
     * 商品规格值
     */
    @Column(name = "spec_value", length = 128, nullable = false)
    private String specValue;

    /**
     * 商品规格图片
     */
    @Column(name = "spec_logo", nullable = false)
    private String specLogo;

}
