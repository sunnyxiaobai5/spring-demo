/*******************************************************************************
 * sunnyxiaobai5@gmail.com
 * <p>
 * <li>项目名称: spring-data-demo</li>
 * <li>完整包名: com.sunnyxiaobai5.web</li>
 * <li>文件名称: MenuResource.java</li>
 * <li>内容摘要: </li>
 * <li>内容描述: </li>
 * <li>其他说明: </li>
 * <li>@author Xiangyong Zeng</li>
 ******************************************************************************/
package com.sunnyxiaobai5.web.rest.resource;

import com.sunnyxiaobai5.common.exception.BaseException;
import com.sunnyxiaobai5.service.auth.MenuService;
import com.sunnyxiaobai5.util.PdfTableUtils;
import com.sunnyxiaobai5.web.rest.dto.MenuDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuResource {


    private static final Logger log = LoggerFactory.getLogger(MenuResource.class);

    @Resource
    private MenuService menuService;

    /**
     * 查询单个菜单
     *
     * @param id 菜单ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MenuDTO> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.findOneDTO(id), HttpStatus.OK);
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<MenuDTO>> findAll() {
        return new ResponseEntity<>(menuService.findAllDTO(), HttpStatus.OK);
    }

    /**
     * 查询某系统下菜单
     *
     * @param systemId 系统ID
     * @return
     */
    @RequestMapping(value = "findModules", method = RequestMethod.GET)
    public ResponseEntity<List<MenuDTO>> findModules(@RequestParam Long systemId) {
        return new ResponseEntity<>(menuService.findModules(systemId), HttpStatus.OK);
    }

    /**
     * 查询所有系统
     *
     * @return
     */
    @RequestMapping(value = "findSystems", method = RequestMethod.GET)
    public ResponseEntity<List<MenuDTO>> findSystems() {
        return new ResponseEntity<>(menuService.findSystems(), HttpStatus.OK);
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void export() {
        //表格标题
        String title = "表格标题";

        try {
            PdfTableUtils.createPdf("pdf/simple_table.pdf", MenuDTO.class, menuService.findAllDTO());
        } catch (BaseException e) {
            if (e.getCode() > 10000) {
                log.info("export fail", e);
            }
        }
    }
}