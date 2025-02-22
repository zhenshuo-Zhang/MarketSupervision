package com.group.marketsupervision.controller;

import com.group.marketsupervision.pojo.Equipment;
import com.group.marketsupervision.pojo.LoginInfo;
import com.group.marketsupervision.pojo.Result;
import com.group.marketsupervision.pojo.User;
import com.group.marketsupervision.service.UserService;
import com.group.marketsupervision.util.ExcelUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登录 , {} {}", user.getUsername(), user.getPassword());
        return userService.login(user);
    }

    @PostMapping("/addEquip")
    public Result addEquip( @RequestBody Equipment equipment) {
        log.info("用户添加设备 , {}", equipment);
        return userService.insertEquipment(equipment);
    }

    @PostMapping("/parseExcel")
    public Result parseExcel(@RequestParam("file") MultipartFile file) {
        try {
            log.info("解析用户上传文件 , {}", file.getOriginalFilename());
            List<Equipment> equipments = ExcelUtil.parse(file);
            return Result.success(equipments);
        } catch (Exception e) {
            e.printStackTrace();
        return Result.error("上传失败，请检查文件格式");
        }
    }

    @PostMapping("/importEquipments")
    public Result importEquipments(@RequestBody List<Equipment> equipments) {
        log.info("导入设备列表 , {}", equipments);
        return userService.importEquipments(equipments);
    }


}
