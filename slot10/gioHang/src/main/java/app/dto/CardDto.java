package app.dto;

import java.util.HashMap;
import java.util.Map;

public class CardDto {
    private Map<ProductDto,Integer> productMap = new HashMap<>();

    public CardDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public  void addProduct(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            Integer value = productMap.get(productDto);
            productMap.put(productDto,value+1);
        }else{
            productMap.put(productDto,1);
        }

    }
    public void minusProduct(ProductDto productDto){
        Integer value = productMap.get(productDto);
        if(value>1){
            productMap.put(productDto,value-1);

        }
    }
    public Long totalPrice(){
        long price = 0;
        for(ProductDto productDto:productMap.keySet()){
            price += productDto.getPrice() * productMap.get(productDto);
        }
        return price;
    }
}
