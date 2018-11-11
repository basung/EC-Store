package com.magicDigit.ecStore.admin.file;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-10-18-下午2:44
 */

@Entity
@Table(name = "BSS_ADMIN_FILE")
@Data
@EntityListeners(AuditingEntityListener.class)
public class VFile extends GenericEntity {

    /**
     * 文件名称
     */
    @Column(name = "name", length = 128)
    private String name;

    /**
     * 文件类型
     */
    @Column(name = "content_type")
    private String contentType;

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private long fileSize;

    /**
     * 文件MD5值
     */
    @Column(name = "file_md5")
    private String fileMd5;


}
