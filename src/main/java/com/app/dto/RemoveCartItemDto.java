package com.app.dto;

public class RemoveCartItemDto {

	
	private Long productId;
	private Long customerId;

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public RemoveCartItemDto(Long productId, Long customerId) {
			super();
			this.productId = productId;
			this.customerId = customerId;
		}

		public RemoveCartItemDto() {
			super();
			
		}
	
		
		
}
