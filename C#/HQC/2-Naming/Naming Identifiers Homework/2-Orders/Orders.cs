namespace Orders
{
    using System;
    using System.Globalization;
    using System.Linq;
    using System.Threading;

    public class Orders
    {
        public static void Main()
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;
            var dataMapper = new DataMapper();
            var allCategories = dataMapper.GetAllCategories();
            var allProducts = dataMapper.GetAllProducts();
            var allOrders = dataMapper.GetAllOrders();

            // Names of the 5 most expensive products
            var mostExpensiveFiveProducts = allProducts
                .OrderByDescending(p => p.UnitPrice)
                .Take(5)
                .Select(p => p.Name);
            Console.WriteLine(string.Join(Environment.NewLine, mostExpensiveFiveProducts));

            Console.WriteLine(new string('-', 10));

            // Number of products in each category
            var productsInCategory = allProducts
                .GroupBy(p => p.CategoryId)
                .Select(group => new { Category = allCategories.First(c => c.Id == group.Key).Name, Count = group.Count() })
                .ToList();
            foreach (var item in productsInCategory)
            {
                Console.WriteLine("{0}: {1}", item.Category, item.Count);
            }

            Console.WriteLine(new string('-', 10));

            // The 5 top products (by order quantity)
            var topFiveProducts = allOrders
                .GroupBy(o => o.ProductId)
                .Select(group => new 
                { 
                        Product = allProducts.First(product => product.Id == group.Key).Name, 
                        Quantities = group.Sum(order => order.Quant) 
                })
                .OrderByDescending(q => q.Quantities)
                .Take(5);
            foreach (var item in topFiveProducts)
            {
                Console.WriteLine("{0}: {1}", item.Product, item.Quantities);
            }

            Console.WriteLine(new string('-', 10));

            // The most profitable category
            var profitableCategory = allOrders
                .GroupBy(order => order.ProductId)
                .Select(group => new 
                { 
                    categoryId = allProducts.First(p => p.Id == group.Key).CategoryId,
                    price = allProducts.First(p => p.Id == group.Key).UnitPrice, quantity = group.Sum(p => p.Quant) 
                })
                .GroupBy(group => group.categoryId)
                .Select(group => new { name = allCategories.First(c => c.Id == group.Key).Name, totalQuantity = group.Sum(product => product.quantity * product.price) })
                .OrderByDescending(group => group.totalQuantity)
                .First();
            Console.WriteLine("{0}: {1}", profitableCategory.name, profitableCategory.totalQuantity);
        }
    }
}
