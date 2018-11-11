package com.magicDigit.ecStore.admin.rolePermission;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:34
 */
@Entity
@Table(name = "BSS_ADMIN_ROLE_PERMISSION")
@Data
public class RolePermission extends GenericEntity {

    @Column(name = "role_id", nullable = false)
    private String roleId;

    @Column(name = "relation_id", nullable = false)
    private String relationId;


}
