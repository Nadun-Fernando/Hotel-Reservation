/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.PackagesBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.PackageDAO;
import lk.hotelme.dto.PackageDTO;
import lk.hotelme.entity.Packages;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class PackagesBOImpl implements PackagesBO{
    public static PackageDAO packdao = (PackageDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.PACKAGE);

    @Override
    public boolean addPackage(PackageDTO pack) throws Exception {
        return packdao.add(new Packages(pack.getPackage_ID(), pack.getPackage_Name(), pack.getPackage_Details(), pack.getPackage_Price()));
    }

    @Override
    public boolean updatePackage(PackageDTO pack) throws Exception {
        return packdao.update(new Packages(pack.getPackage_ID(), pack.getPackage_Name(), pack.getPackage_Details(), pack.getPackage_Price()));
    }

    @Override
    public boolean deletePackage(String ID) throws Exception {
        return packdao.delete(ID);
    }

    @Override
    public PackageDTO searchPackage(String ID) throws Exception {
        Packages search = packdao.search(ID);
        return new PackageDTO(search.getPackage_ID(), search.getPackage_Name(), search.getPackage_Details(), search.getPackage_Price());
    }

    @Override
    public ArrayList<PackageDTO> loadallPackage() throws Exception {
        ArrayList<PackageDTO> packages = new ArrayList<>();
        ArrayList<Packages> loadAll = packdao.loadAll();
        for (Packages packages1 : loadAll) {
            packages.add(new PackageDTO(packages1.getPackage_ID(), packages1.getPackage_Name(), packages1.getPackage_Details(), packages1.getPackage_Price()));
        }
        return packages;
    }
    
}
