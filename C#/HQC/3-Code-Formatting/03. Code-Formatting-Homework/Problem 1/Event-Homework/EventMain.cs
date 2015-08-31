namespace Event_Homework
{
    using System;
    using System.Text;

    public class EventMain
    {
        private static void Main(string[] args)
        {
            while (ExecuteNextCommand())
            {
                Console.WriteLine(Messages.Output);
            }
        }

        private static bool ExecuteNextCommand()
        {
            string command = Console.ReadLine();
            if (command[0] == 'A')
            {
                AddEvent(command);
                return true;
            }

            if (command[0] == 'D')
            {
                DeleteEvents(command);
                return true;
            }

            if (command[0] == 'L')
            {
                ListEvents(command);
                return true;
            }

            if (command[0] == 'E')
            {
                return false;
            }

            return false;
        }

        private static void ListEvents(string command)
        {
            int pipeIndex = command.IndexOf('|');
            DateTime date = Messages.GetDate(command, "ListEvents");
            string countString = command.Substring(pipeIndex + 1);
            int count = int.Parse(countString);
            Messages.Events.ListEvents(date, count);
        }

        private static void DeleteEvents(string command)
        {
            string title = command.Substring("DeleteEvents".Length + 1);
            Messages.Events.DeleteEvents(title);
        }

        private static void AddEvent(string command)
        {
            DateTime date;
            string title;
            string location;
            Messages.GetParameters(command, "AddEvent", out date, out title, out location);
            Messages.Events.AddEvent(date, title, location);
        }
    }
}