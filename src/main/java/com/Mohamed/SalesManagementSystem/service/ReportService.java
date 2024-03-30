package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Client;
import com.Mohamed.SalesManagementSystem.model.Product;
import com.Mohamed.SalesManagementSystem.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService{

    @Autowired
    private SaleService salesService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;


    public Map<String, Object> generateSalesReport(LocalDate startDate, LocalDate endDate) {
        Map<String, Object> salesReport = new HashMap<>();

        List<Sale> sales = salesService.getSalesBetweenDates(startDate, endDate);

        Integer totalRevenue = 0;
        Integer maxTotal = 0;

        List<String> topSellingProducts = new ArrayList<>();

        List<String> topPerformingSellers = new ArrayList<>();

        List<Integer> totals = new ArrayList<>();

        for (Sale sale : sales) {
            totalRevenue += sale.getTotal();
            addSellerAndProduct(topPerformingSellers, sale.getSeller(), topSellingProducts, sale.getProduct(), totals, sale.getTotal() );
        }

        salesReport.put("startDate", startDate);
        salesReport.put("endDate", endDate);
        salesReport.put("totalSales", sales.size());
        salesReport.put("totalRevenue", totalRevenue);
        salesReport.put("topSellingProducts", topSellingProducts);
        salesReport.put("topPerformingSellers", topPerformingSellers);

        return salesReport;
    }

    public Map<String, Object> generateClientReport() {
        Map<String, Object> clientReport = new HashMap<>();

        List<Client> clients = clientService.getAllClients();
        List<Sale> sales = salesService.getAllSales();

        List<String> topSpendingClients = new ArrayList<>();
        List<Integer> totals = new ArrayList<>();


        for (Sale sale : sales) {
            addClient(topSpendingClients, sale.getClient() , totals, sale.getTotal());
        }
        // Calculate total number of clients, top-spending clients, client activity, and client location statistics

        clientReport.put("totalClients", clients.size());
        clientReport.put("top-spending clients", topSpendingClients);
        clientReport.put("client activity", List.of());
        clientReport.put("client location statistics", List.of());
        // Add other client-related information to the map...

        return clientReport;
    }

    public Map<String, Object> generateProductReport() {
        Map<String, Object> productReport = new HashMap<>();

        List<Product> products = productService.getAllProducts();

        //  Calculate inventory status, sales performance, and pricing analysis

        productReport.put("totalProducts", products.size());
        productReport.put("sales performance", List.of());
        productReport.put("pricing analysis", List.of());
        // Add other product-related information to the map...

        return productReport;
    }

    private void addClient(List<String> clients, String client, List<Integer> totals, Integer total) {

        if(clients.size() >= 3){
            Integer min = totals.get(0);
            int index = 0;
            for (int i = 1; i < clients.size(); i++) {
                if(min > totals.get(i)){
                    min = totals.get(i);
                    index = i;
                }
            }
            if(total > totals.get(index)) {
                clients.remove(index);
                totals.remove(index);
            }
            else
                return;
        }
        clients.add(client);
        totals.add(total);

    }

    private void addSellerAndProduct(List<String> sales, String seller, List<String> products, String product, List<Integer> totals, Integer total) {

        if(sales.size() >= 3){
            Integer min = totals.get(0);
            int index = 0;
            for (int i = 1; i < sales.size(); i++) {
                if(min > totals.get(i)){
                    min = totals.get(i);
                    index = i;
                }
            }
            if(total > totals.get(index)) {
                sales.remove(index);
                products.remove(index);
                totals.remove(index);
            }
            else
                return;
        }
        sales.add(seller);
        products.add(product);
        totals.add(total);

    }

}