package cn.test.controller;

import cn.test.entity.DevUser;
import cn.test.service.DevUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DevUser)表控制层
 *
 * @author makejava
 * @since 2023-06-07 10:07:50
 */
@RestController
@RequestMapping("devUser")
public class DevUserController {
    /**
     * 服务对象
     */
    @Resource
    private DevUserService devUserService;

    /**
     * 分页查询
     *
     * @param devUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DevUser>> queryByPage(DevUser devUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.devUserService.queryByPage(devUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DevUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.devUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param devUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DevUser> add(DevUser devUser) {
        return ResponseEntity.ok(this.devUserService.insert(devUser));
    }

    /**
     * 编辑数据
     *
     * @param devUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DevUser> edit(DevUser devUser) {
        return ResponseEntity.ok(this.devUserService.update(devUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.devUserService.deleteById(id));
    }

}

