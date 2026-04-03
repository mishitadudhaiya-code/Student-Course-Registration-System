package services;

import model.Complaint;
import java.util.ArrayList;

public class ComplaintService {

    private static ComplaintService instance;
    private ArrayList<Complaint> complaints;

    private ComplaintService() {
        complaints = new ArrayList<>();
    }

    public static ComplaintService getInstance() {
        if (instance == null) {
            instance = new ComplaintService();
        }
        return instance;
    }

    public void addComplaint(Complaint c) {
        complaints.add(c);
    }

    public ArrayList<Complaint> getAllComplaints() {
        return complaints;
    }
}