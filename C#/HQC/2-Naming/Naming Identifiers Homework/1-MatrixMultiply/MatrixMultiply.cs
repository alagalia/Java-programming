// <copyright file="MatrixMultiply.cs" company="CompanyName">
//    Company copyright tag.
// </copyright>
namespace ConsoleApplication1
{
    using System;

    internal class MatrixMultiply
    {
        private static void Main()
        {
            var fisrtMatrix = new double[,]
            {
                { 1, 3 },
                { 5, 7 }
            };

            var secondMatrix = new double[,]
            {
                { 4, 2 },
                { 1, 5 }
            };

            double[,] resultMatrix = ProductOfTwoMatrix(fisrtMatrix, secondMatrix);

            for (int row = 0; row < resultMatrix.GetLength(0); row++)
            {
                for (int col = 0; col < resultMatrix.GetLength(1); col++)
                {
                    Console.Write(resultMatrix[row, col] + " ");
                }

                Console.WriteLine();
            }
        }

       /// <summary>Method for multiply two two dimensional matrices 
       /// </summary>
       /// <param name="firstMatrix">First matrix</param>
       /// <param name="secondMatrix">Second matrix</param>
       /// <returns>Multiplied matrix</returns>
        private static double[,] ProductOfTwoMatrix(double[,] firstMatrix, double[,] secondMatrix)
        {
            if (firstMatrix.GetLength(1) != secondMatrix.GetLength(0))
            {
                throw new Exception("Error!");
            }

            var firstMatrixCols = firstMatrix.GetLength(1);

            var resultMatrix = new double[firstMatrix.GetLength(0), secondMatrix.GetLength(1)];

            for (int row = 0; row < resultMatrix.GetLength(0); row++)
            {
                for (int col = 0; col < resultMatrix.GetLength(1); col++)
                {
                    for (int colFirstRowSecond = 0; colFirstRowSecond < firstMatrixCols; colFirstRowSecond++)
                    {
                        resultMatrix[row, col] += firstMatrix[row, colFirstRowSecond] * secondMatrix[colFirstRowSecond, col];
                    }
                }
            }

            return resultMatrix;
        }
    }
}