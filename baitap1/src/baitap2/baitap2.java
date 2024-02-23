package baitap2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	class Category {
	    String name;

	    public Category(String name) {
	        this.name = name;
	    }
	}

	class Product {
	    Long id;
	    String name;
	    Double price;
	    Integer quantity;
	    Category category;

	    public Product(Long id, String name, Double price, Integer quantity, Category category) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        this.category = category;
	    }
	}

	class ProductManager {
	    List<Product> productList;

	    public ProductManager() {
	        productList = new ArrayList<>();
	    }

	    public void createProduct(Long id, String name, Double price, Integer quantity, Category category) {
	        Product product = new Product(id, name, price, quantity, category);
	        productList.add(product);
	        System.out.println("Product created successfully.");
	    }

	    public void updateProduct(Long id, String name, Double price, Integer quantity, Category category) {
	        for (Product product : productList) {
	            if (product.id.equals(id)) {
	                product.name = name;
	                product.price = price;
	                product.quantity = quantity;
	                product.category = category;
	                System.out.println("Product updated successfully.");
	                return;
	            }
	        }
	        System.out.println("Product not found with ID: " + id);
	    }

	    public void deleteProduct(Long id) {
	        productList.removeIf(product -> product.id.equals(id));
	        System.out.println("Product deleted successfully.");
	    }

	    public void displayProductById(Long id) {
	        for (Product product : productList) {
	            if (product.id.equals(id)) {
	                displayProductDetails(product);
	                return;
	            }
	        }
	        System.out.println("Product not found with ID: " + id);
	    }

	    public void displayAllProducts() {
	        for (Product product : productList) {
	            displayProductDetails(product);
	        }
	    }

	    public void displayProductsByCategory(Category category) {
	        for (Product product : productList) {
	            if (product.category.equals(category)) {
	                displayProductDetails(product);
	            }
	        }
	    }

	    public void displayTotalPrice() {
	        double total = 0;
	        for (Product product : productList) {
	            total += (product.price * product.quantity);
	        }
	        System.out.println("Total price of all products: " + total);
	    }

	    public void displayProductsAbovePrice(double price) {
	        for (Product product : productList) {
	            if (product.price > price) {
	                displayProductDetails(product);
	            }
	        }
	    }

	    public void displayElectronicsAbovePrice(double price) {
	        for (Product product : productList) {
	            if (product.price > price && product.category.name.equals("Điện tử")) {
	                displayProductDetails(product);
	            }
	        }
	    }

	    private void displayProductDetails(Product product) {
	        System.out.println("ID: " + product.id);
	        System.out.println("Name: " + product.name);
	        System.out.println("Price: " + product.price);
	        System.out.println("Quantity: " + product.quantity);
	        System.out.println("Category: " + product.category.name);
	        System.out.println("----------------------");
	    }
	}

	public class baitap2 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ProductManager productManager = new ProductManager();

	        Category electronicsCategory = new Category("Điện tử");
	        Category clothingCategory = new Category("Thời trang");
	        Category foodCategory = new Category("Thực phẩm");

	        // Menu
	        while (true) {
	            System.out.println("1. Tạo mới sản phẩm");
	            System.out.println("2. Sửa thông tin sản phẩm");
	            System.out.println("3. Xóa sản phẩm");
	            System.out.println("4. Hiển thị thông tin sản phẩm theo ID");
	            System.out.println("5. Hiển thị tất cả sản phẩm");
	            System.out.println("6. Hiển thị tất cả sản phẩm theo loại");
	            System.out.println("7. Tính tổng tiền của các sản phẩm hiện có");
	            System.out.println("8. Hiển thị các sản phẩm có giá tiền > 100000");
	            System.out.println("9. Hiển thị các sản phẩm có giá tiền > 200000 và có Category là 'Điện tử'");
	            System.out.println("0. Thoát");

	            System.out.print("Chọn chức năng: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Nhập ID: ");
	                    Long id = scanner.nextLong();
	                    scanner.nextLine();
	                    System.out.print("Nhập tên sản phẩm: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Nhập giá tiền: ");
	                    Double price = scanner.nextDouble();
	                    System.out.print("Nhập số lượng: ");
	                    Integer quantity = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("Nhập loại sản phẩm (Điện tử, Thời trang, Thực phẩm): ");
	                    String categoryName = scanner.nextLine();
	                    Category category = null;
	                    if (categoryName.equals("Điện tử")) {
	                        category = electronicsCategory;
	                    } else if (categoryName.equals("Thời trang")) {
	                        category = clothingCategory;
	                    } else if (categoryName.equals("Thực phẩm")) {
	                        category = foodCategory;
	                    }
	                    productManager.createProduct(id, name, price, quantity, category);
	                    break;
	                case 2:
	                    System.out.print("Nhập ID sản phẩm cần sửa: ");
	                    Long updateId = scanner.nextLong();
	                    scanner.nextLine();
	                    System.out.print("Nhập tên mới (nhấn Enter nếu không sửa): ");
	                    String updateName = scanner.nextLine();
	                    System.out.print("Nhập giá tiền mới (nhấn Enter nếu không sửa): ");
	                    Double updatePrice = scanner.nextDouble();
	                    System.out.print("Nhập số lượng mới (nhấn Enter nếu không sửa): ");
	                    Integer updateQuantity = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("Nhập loại sản phẩm mới (nhấn Enter nếu không sửa): ");
	                    String updateCategoryName = scanner.nextLine();
	                    Category updateCategory = null;
	                    if (!updateCategoryName.isEmpty()) {
	                        if (updateCategoryName.equals("Điện tử")) {
	                            updateCategory = electronicsCategory;
	                        } else if (updateCategoryName.equals("Thời trang")) {
	                            updateCategory = clothingCategory;
	                        } else if (updateCategoryName.equals("Thực phẩm")) {
	                            updateCategory = foodCategory;
	                        }
	                    }
	                    productManager.updateProduct(updateId, updateName, updatePrice, updateQuantity, updateCategory);
	                    break;
	                case 3:
	                    System.out.print("Nhập ID sản phẩm cần xóa: ");
	                    Long deleteId = scanner.nextLong();
	                    productManager.deleteProduct(deleteId);
	                    break;
	                case 4:
	                    System.out.print("Nhập ID sản phẩm cần hiển thị: ");
	                    Long displayId = scanner.nextLong();
	                    productManager.displayProductById(displayId);
	                    break;
	                case 5:
	                    productManager.displayAllProducts();
	                    break;
	                case 6:
	                    System.out.print("Nhập loại sản phẩm cần hiển thị: ");
	                    String displayCategoryName = scanner.nextLine();
	                    Category displayCategory = null;
	                    if (displayCategoryName.equals("Điện tử")) {
	                        displayCategory = electronicsCategory;
	                    } else if (displayCategoryName.equals("Thời trang")) {
	                        displayCategory = clothingCategory;
	                    } else if (displayCategoryName.equals("Thực phẩm")) {
	                        displayCategory = foodCategory;
	                    }
	                    productManager.displayProductsByCategory(displayCategory);
	                    break;
	                case 7:
	                    productManager.displayTotalPrice();
	                    break;
	                case 8:
	                    System.out.print("Nhập giá tiền cần so sánh: ");
	                    double abovePrice = scanner.nextDouble();
	                    productManager.displayProductsAbovePrice(abovePrice);
	                    break;
	                case 9:
	                    productManager.displayElectronicsAbovePrice(200000);
	                    break;
	                case 0:
	                    System.out.println("Thoát chương trình.");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Chọn chức năng không hợp lệ. Hãy chọn lại.");
	            }
	       }
	 }
}

