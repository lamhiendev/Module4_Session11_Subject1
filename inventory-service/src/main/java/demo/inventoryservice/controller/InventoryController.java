package demo.inventoryservice.controller;

import demo.inventoryservice.entity.Medicine;
import demo.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable Long id){
        return inventoryService.getMedicineById(id);
    }
}
