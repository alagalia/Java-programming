using System;
using System.Text;


public class Event : IComparable
{
    private DateTime date;
    private string title;
    private string location;

    public Event(DateTime date, string title, string location)
    {
        this.date = date;
        this.title = title;
        this.location = location;
    }

    public int CompareTo(object obj)
    {
        Event other = obj as Event;
        int byDate = date.CompareTo(other.date);
        int byTitle = title.CompareTo(other.title);
        var byLocation = location.CompareTo(other.location);

        if (byDate == 0)
        {
            if (byTitle == 0)
            {
                return byLocation;
            }

            return byTitle;
        }

        return byDate;
    }

    public override string ToString()
    {
        StringBuilder toString = new StringBuilder();
        toString.Append(this.date.ToString("yyyy-MM-ddTHH:mm:ss"));
        toString.Append(" | " + this.title);

        if (!string.IsNullOrEmpty(this.location))
        {
            toString.Append(" | " + this.location);
        }

        return toString.ToString();
    }
}
