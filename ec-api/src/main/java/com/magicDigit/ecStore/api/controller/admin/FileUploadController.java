package com.magicDigit.ecStore.api.controller.admin;

/**
 * Date: 2018-10-17-下午4:22
 */

import com.magicDigit.ecStore.admin.file.VFile;
import com.magicDigit.ecStore.admin.file.VFileService;
import com.magicDigit.ecStore.api.utils.ControllerUtils;
import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.base.file.FileUtils;
import com.magicDigit.ecStore.base.support.StrKit;
import com.magicDigit.ecStore.common.controller.AutoEntityController;
import com.magicDigit.ecStore.common.controller.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;


@Api(value = "上传单个文件", tags = {"上传单个文件"})
@RestController
@RequestMapping(value = "/file")
public class FileUploadController extends AutoEntityController<VFile, String, GlobalException, VFileService> {

    Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Value("${file.upload.path}")
    private String UPLOADED_FOLDER;


    @Autowired
    private VFileService vFileService;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = vFileService;
    }


    @ApiOperation(value = "文件上传接口", notes = "文件上传接口")
    @PostMapping("/upload")
    public void upload(@RequestParam("uploadFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
	  if (file.isEmpty()) {
		ResponseUtils.writeErrorResult(response, 400, "请选择一个文件");
	  }

//	  logger.info(" ContentType === {}  ", file.getContentType());
//	  logger.info(" name === {}  ", file.getName());
//	  logger.info(" OriginalFilename === {}  ", file.getOriginalFilename());
//	  logger.info(" Size === {}  ", file.getSize());
//	  logger.info(" UPLOADED_FOLDER === {}  ", UPLOADED_FOLDER);



	  //获取图片MD5值

	  String fileMd5 = FileUtils.getFileMd5(file);
	  logger.info(" fileMd5 === {}  ", fileMd5);

	  if(!vFileService.existsByMD5(fileMd5)){
		String filePath = FileUtils.upload(file, UPLOADED_FOLDER + "rocky/");
		VFile vFile = new VFile();
		vFile.setName(file.getOriginalFilename());
		vFile.setContentType(file.getContentType());
		vFile.setFileSize(file.getSize());
		vFile.setFilePath(StrKit.removePrefixIgnoreCase(filePath, "/Users/wangyang/github/Java/EC-Store/static/"));
		vFile.setFileMd5(fileMd5);
		controllerUtils.setTenantInfoByCreate(vFile);
		addAutoEntityCustom(vFile, request, response);
	  }else {
	      VFile vFile = vFileService.getFileByMd5(fileMd5);
		ResponseUtils.writeSuccessResult(response, vFile);
	  }




    }

    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = VFile.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  queryAutoEntity(request, response);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = VFile.class)
    public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
	  getAutoEntity(id, response);
    }


}
