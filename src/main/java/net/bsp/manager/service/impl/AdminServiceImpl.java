package net.bsp.manager.service.impl;

import java.util.List;

import net.bsp.manager.dao.AdminDAO;
import net.bsp.manager.model.Admin;
import net.bsp.manager.model.Criteria;
import net.bsp.manager.model.PageInfo;
import net.bsp.manager.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;
    
    @Override
    public int countByCriteria(Criteria criteria) {
        return adminDAO.countByExample(criteria);
    }

    @Override
    public Long add(Admin record) {
        adminDAO.insert(record);
        return record.getId();
    }

    @Override
    public List<Admin> findListByCriteria(Criteria criteria) {
        return adminDAO.selectByExample(criteria);
    }

    @Override
    public Admin findById(Long id) {
        return adminDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(Admin record) {
        return adminDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDAO.selectByUsername(username);
    }

    @Override
    public PageInfo<Admin> findListByCriteria(Criteria criteria, int pageNo, int pageSize) {
        PageInfo<Admin> res = new PageInfo<Admin>(pageNo, pageSize);
        int total=this.countByCriteria(criteria);
        res.setTotal(total);
        
        criteria.setOffset(res.getOffset());
        criteria.setRows(pageSize);
        List<Admin> list = this.findListByCriteria(criteria);
        res.setData(list);
        return res;
    }

}
