package cn.test.controller;

import cn.test.entity.DataDictionary;
import cn.test.service.DataDictionaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DataDictionary)表控制层
 *
 * @author makejava
 * @since 2023-06-07 10:22:11
 */
@RestController
@RequestMapping("dataDictionary")
public class DataDictionaryController {
    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    /**
     * 分页查询
     *
     * @param dataDictionary 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DataDictionary>> queryByPage(DataDictionary dataDictionary, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dataDictionaryService.queryByPage(dataDictionary, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DataDictionary> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.dataDictionaryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dataDictionary 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DataDictionary> add(DataDictionary dataDictionary) {
        return ResponseEntity.ok(this.dataDictionaryService.insert(dataDictionary));
    }

    /**
     * 编辑数据
     *
     * @param dataDictionary 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DataDictionary> edit(DataDictionary dataDictionary) {
        return ResponseEntity.ok(this.dataDictionaryService.update(dataDictionary));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.dataDictionaryService.deleteById(id));
    }

}

