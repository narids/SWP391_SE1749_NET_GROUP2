/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultils;

import java.util.List;

/**
 *
 * @author admin
 */
public class Pagination {

    /**
     * Paginate list inputted
     *
     * @param list List which need to be paginated
     * @param page no of page
     * @param itemsPerPage number of items per page
     * @return List which is paginated
     */
    public <T> List<T> paginateRecords(List<T> list, int page, int itemsPerPage) {
        int startIndex = (page - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, list.size());
        return list.subList(startIndex, endIndex);
    }
}
