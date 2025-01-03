import model.dao.SellerDao;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        System.out.println(sellerDao.findById(1));

        System.out.println();
        System.out.println("=== TEST 2: Seller findByDepartmentId ===");
        List<Seller> sellers = sellerDao.findByDepartmentId(10);
        for(Seller seller : sellers){
            System.out.println(seller);
        }

        System.out.println();
        System.out.println("=== TEST 3: Seller findAll ===");
        List<Seller> sellersFindAll = sellerDao.findAll();
        for(Seller seller : sellersFindAll){
            System.out.println(seller);
        }

//        System.out.println();
//        System.out.println("=== TEST 4: Insert seller ===");
//        Seller sellerAhSerInserido = new Seller("Renan", "renan@gmail.com", new Date(), 3000.0, new Department(1));
//        Integer id = sellerDao.insert(sellerAhSerInserido);
//        System.out.println(sellerDao.findById(id));

        System.out.println();
        System.out.println("=== TEST 5: Update seller ===");
        Seller sellerAhSerAutalizado = new Seller(7, "Renan", "atualizado@gmail.com", new Date(), 3000.0, new Department(1));
        sellerDao.update(sellerAhSerAutalizado);
        System.out.println(sellerDao.findById(7));

        System.out.println();
        System.out.println("=== TEST 6: delete seller ===");
        sellerDao.deleteById(2);
        sellersFindAll = sellerDao.findAll();
        for(Seller seller : sellersFindAll){
            System.out.println(seller);
        }
    }
}