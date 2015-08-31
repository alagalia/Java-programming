namespace Application2
{
    using System;
    using System.Collections.Generic;

    public class MinesweeperEngine
    {
        private static void Main()
        {
            string command = string.Empty;
            char[,] board = CreateBoard();
            char[,] bombs = BombGenerator();
            int counter = 0;
            bool isBomb = false;
            List<Player> winners = new List<Player>(6);
            int row = 0;
            int col = 0;
            bool isOnTheStart = true;
            const int BoardCells = 35;
            bool isWinner = false;

            do
            {
                if (isOnTheStart)
                {
                    Console.WriteLine(
                        "Hajde da igraem na “Mini4KI”. Probvaj si kasmeta da otkriesh poleteta bez mini4ki."
                        + " Komanda 'top' pokazva klasiraneto, 'restart' po4va nova igra, 'exit' izliza i hajde 4ao!");
                    DrawPlayGround(board);
                    isOnTheStart = false;
                }

                Console.Write("Daj red i kolona : ");
                command = Console.ReadLine().Trim();
                if (command.Length >= 3)
                {
                    if (int.TryParse(command[0].ToString(), out row) && int.TryParse(command[2].ToString(), out col)
                        && row <= board.GetLength(0) && col <= board.GetLength(1))
                    {
                        command = "turn";
                    }
                }

                switch (command)
                {
                    case "top":
                        GetScore(winners);
                        break;
                    case "restart":
                        board = CreateBoard();
                        bombs = BombGenerator();
                        DrawPlayGround(board);
                        isBomb = false;
                        isOnTheStart = false;
                        break;
                    case "exit":
                        Console.WriteLine("4a0, 4a0, 4a0!");
                        break;
                    case "turn":
                        if (bombs[row, col] != '*')
                        {
                            if (bombs[row, col] == '-')
                            {
                                NextTurn(board, bombs, row, col);
                                counter++;
                            }

                            if (BoardCells == counter)
                            {
                                isWinner = true;
                            }
                            else
                            {
                                DrawPlayGround(board);
                            }
                        }
                        else
                        {
                            isBomb = true;
                        }

                        break;
                    default:
                        Console.WriteLine("\nGreshka! nevalidna Komanda\n");
                        break;
                }

                if (isBomb)
                {
                    DrawPlayGround(bombs);
                    Console.Write("\nHrrrrrr! Umria gerojski s {0} to4ki. " + "Daj si niknejm: ", counter);
                    string niknejm = Console.ReadLine();
                    Player t = new Player(niknejm, counter);
                    if (winners.Count < 5)
                    {
                        winners.Add(t);
                    }
                    else
                    {
                        for (int i = 0; i < winners.Count; i++)
                        {
                            if (winners[i].Points < t.Points)
                            {
                                winners.Insert(i, t);
                                winners.RemoveAt(winners.Count - 1);
                                break;
                            }
                        }
                    }

                    winners.Sort((Player r1, Player r2) => r2.Name.CompareTo(r1.Name));
                    winners.Sort((Player r1, Player r2) => r2.Points.CompareTo(r1.Points));
                    GetScore(winners);

                    board = CreateBoard();
                    bombs = BombGenerator();
                    counter = 0;
                    isBomb = false;
                    isOnTheStart = true;
                }

                if (isWinner)
                {
                    Console.WriteLine("\nBRAVOOOS! Otvri 35 kletki bez kapka kryv.");
                    DrawPlayGround(bombs);
                    Console.WriteLine("Daj si imeto, batka: ");
                    string name = Console.ReadLine();
                    Player to4kii = new Player(name, counter);
                    winners.Add(to4kii);
                    GetScore(winners);
                    board = CreateBoard();
                    bombs = BombGenerator();
                    counter = 0;
                    isWinner = false;
                    isOnTheStart = true;
                }
            }
            while (command != "exit");
            Console.WriteLine("Made in Bulgaria - Uauahahahahaha!");
            Console.WriteLine("AREEEEEEeeeeeee.");
            Console.Read();
        }

        private static void GetScore(List<Player> players)
        {
            Console.WriteLine("\nTo4KI:");
            if (players.Count > 0)
            {
                for (int i = 0; i < players.Count; i++)
                {
                    Console.WriteLine("{0}. {1} --> {2} kutii", i + 1, players[i].Name, players[i].Points);
                }

                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("prazna klasaciq!\n");
            }
        }

        private static void NextTurn(char[,] board, char[,] bombs, int row, int col)
        {
            char existingBombs = BombCalculator(bombs, row, col);
            bombs[row, col] = existingBombs;
            board[row, col] = existingBombs;
        }

        private static void DrawPlayGround(char[,] board)
        {
            int rows = board.GetLength(0);
            int cols = board.GetLength(1);
            Console.WriteLine("\n    0 1 2 3 4 5 6 7 8 9");
            Console.WriteLine("   ---------------------");
            for (int i = 0; i < rows; i++)
            {
                Console.Write("{0} | ", i);
                for (int j = 0; j < cols; j++)
                {
                    Console.Write(string.Format("{0} ", board[i, j]));
                }

                Console.Write("|");
                Console.WriteLine();
            }

            Console.WriteLine("   ---------------------\n");
        }

        private static char[,] CreateBoard()
        {
            int boardRows = 5;
            int boardColumns = 10;
            char[,] board = new char[boardRows, boardColumns];
            for (int i = 0; i < boardRows; i++)
            {
                for (int j = 0; j < boardColumns; j++)
                {
                    board[i, j] = '?';
                }
            }

            return board;
        }

        private static char[,] BombGenerator()
        {
            int rows = 5;
            int cols = 10;
            char[,] boardWithBombs = new char[rows, cols];

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    boardWithBombs[row, col] = '-';
                }
            }

            List<int> randomList = new List<int>();
            while (randomList.Count < 15)
            {
                Random random = new Random();
                int randomNum = random.Next(50);
                if (!randomList.Contains(randomNum))
                {
                    randomList.Add(randomNum);
                }
            }

            foreach (int randomNum in randomList)
            {
                int col = randomNum / cols;
                int row = randomNum % cols;
                if (row == 0 && randomNum != 0)
                {
                    col--;
                    row = cols;
                }
                else
                {
                    row++;
                }

                boardWithBombs[col, row - 1] = '*';
            }

            return boardWithBombs;
        }

        private static char BombCalculator(char[,] bombs, int row, int col)
        {
            int bombCounter = 0;
            int rows = bombs.GetLength(0);
            int cols = bombs.GetLength(1);

            if (row - 1 >= 0)
            {
                if (bombs[row - 1, col] == '*')
                {
                    bombCounter++;
                }
            }

            if (row + 1 < rows)
            {
                if (bombs[row + 1, col] == '*')
                {
                    bombCounter++;
                }
            }

            if (col - 1 >= 0)
            {
                if (bombs[row, col - 1] == '*')
                {
                    bombCounter++;
                }
            }

            if (col + 1 < cols)
            {
                if (bombs[row, col + 1] == '*')
                {
                    bombCounter++;
                }
            }

            if ((row - 1 >= 0) && (col - 1 >= 0))
            {
                if (bombs[row - 1, col - 1] == '*')
                {
                    bombCounter++;
                }
            }

            if ((row - 1 >= 0) && (col + 1 < cols))
            {
                if (bombs[row - 1, col + 1] == '*')
                {
                    bombCounter++;
                }
            }

            if ((row + 1 < rows) && (col - 1 >= 0))
            {
                if (bombs[row + 1, col - 1] == '*')
                {
                    bombCounter++;
                }
            }

            if ((row + 1 < rows) && (col + 1 < cols))
            {
                if (bombs[row + 1, col + 1] == '*')
                {
                    bombCounter++;
                }
            }

            return char.Parse(bombCounter.ToString());
        }
    }
}