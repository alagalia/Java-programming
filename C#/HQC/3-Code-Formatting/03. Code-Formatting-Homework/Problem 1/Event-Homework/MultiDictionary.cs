namespace Event_Homework
{
    using System.Diagnostics.Eventing.Reader;

    public class MultiDictionary<T1, T2>
    {
       public MultiDictionary(bool check)
       {
           this.Check = check;
       }

        public bool Check { get; set; }

        internal void Add(string p, Event newEvent)
        {
            throw new System.NotImplementedException();
        }

        internal void Remove(string title)
        {
            throw new System.NotImplementedException();
        }
    }
}