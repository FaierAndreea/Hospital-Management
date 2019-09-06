
import procedures.Prescription;

import java.util.Comparator;

class Sortbypills implements Comparator<Prescription>
{
    public int compare(Prescription a, Prescription b)
    {
        return a.getPillsPerDay() - b.getPillsPerDay();
    }
}

