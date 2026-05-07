use foodDB   // create/use database

db.createCollection("orders")   // create collection

db.orders.insertMany([
  {
    "order_id": 101,
    "customer_name": "Rahul",
    "restaurant": "Pizza Hut",
    "food_item": "Pizza",
    "quantity": 2,
    "price": 500,
    "city": "Bangalore",
    "status": "Delivered"
  },
  {
    "order_id": 102,
    "customer_name": "Sneha",
    "restaurant": "Dominos",
    "food_item": "Burger",
    "quantity": 1,
    "price": 200,
    "city": "Delhi",
    "status": "Pending"
  },
  {
    "order_id": 103,
    "customer_name": "Arjun",
    "restaurant": "KFC",
    "food_item": "Fried Chicken",
    "quantity": 3,
    "price": 750,
    "city": "Mumbai",
    "status": "Delivered"
  },
  {
    "order_id": 104,
    "customer_name": "Priya",
    "restaurant": "Subway",
    "food_item": "Sandwich",
    "quantity": 2,
    "price": 300,
    "city": "Chennai",
    "status": "Pending"
  },
  {
    "order_id": 105,
    "customer_name": "Vikram",
    "restaurant": "Burger King",
    "food_item": "Whopper",
    "quantity": 1,
    "price": 350,
    "city": "Bangalore",
    "status": "Delivered"
  }
])

// Display all orders
db.orders.find()

// Orders from a specific city (e.g., Bangalore)
db.orders.find({ city: "Bangalore" })

// Only delivered orders
db.orders.find({ status: "Delivered" })

db.orders.aggregate([
  { $group: { _id: "$city", totalRevenue: { $sum: "$price" } } }
])

db.orders.aggregate([
  { $group: { _id: "$food_item", totalQuantity: { $sum: "$quantity" } } },
  { $sort: { totalQuantity: -1 } },
  { $limit: 1 }
])

db.orders.aggregate([
  { $group: { _id: "$restaurant", avgOrderValue: { $avg: "$price" } } }
])
db.orders.aggregate([
  { $group: { _id: "$status", count: { $sum: 1 } } }
])

// Index on customer_name
db.orders.createIndex({ customer_name: 1 })

// Index on city
db.orders.createIndex({ city: 1 })

// Orders where price > 300, sorted descending
db.orders.find({ price: { $gt: 300 } }).sort({ price: -1 })
