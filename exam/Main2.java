package exam;

public class Main2 {

	private static final String QUERY1 = "SELECT * FORM items WHERE price > 50 ORDER BY price";
	private static final String QUERY2 = "INSERT INTO items(name, description) VALUES(\"product 1\", \"desc 1\")";
	private static final String QUERY3 = "DELETE FROM users WHERE id = 7";
	private static final String QUERY4 = "SELECT * FROM users JOIN messages ON messages.user_id = users.id WHERE message IS NOT NULL ORDER BY users.id";
	private static final String QUERY5 = "SELECT max(price) FROM items JOIN items_orders ON items_orders.item_id = items.id JOIN orders ON orders.id = items_orders.order_id WHERE orders.id = 2";
	private static final String QUERY6 = "SELECT * FROM orders WHERE created = \"2017-11-12\"";
	private static final String QUERY7 = "INSERT INTO items_orders(item_id, order_id) VALUES(2, 6)";
	
}
