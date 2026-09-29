package demo.inventoryservice.service;

import demo.inventoryservice.entity.Medicine;
import demo.inventoryservice.event.OrderEvent;
import demo.inventoryservice.repository.MedicineRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final MedicineRepository medicineRepository;
    @Cacheable(value = "medicine",key = "#id")
    public Medicine getMedicineById(Long id){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return medicine;
    }
//    @Transactional
//    public void processOrder(OrderEvent event) {
//
//        int updatedRows = medicineRepository.decreaseStock(
//                event.getMedicineId(),
//                event.getQuantity()
//        );
//
//        if (updatedRows == 0) {
//            throw new RuntimeException(
//                    "Không đủ tồn kho hoặc không tìm thấy thuốc: "
//                            + event.getMedicineId()
//            );
//        }
//
//        System.out.println(
//                "Đã trừ " + event.getQuantity()
//                        + " thuốc " + event.getMedicineId()
//        );
//    }
}
