package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    Integer insert(Seller seller);

    void update(Seller seller);

    void deleteById(Integer sellerId);

    Seller findById(Integer sellerId);

    List<Seller> findByDepartmentId(Integer departmentId);

    List<Seller> findAll();

}
