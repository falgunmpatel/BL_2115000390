import java.util.*;

class Policy implements Comparable<Policy> {
  private String policyNumber;
  private String policyholderName;
  private Date expiryDate;
  private String coverageType;
  private double premiumAmount;

  public Policy(
      String policyNumber,
      String policyholderName,
      Date expiryDate,
      String coverageType,
      double premiumAmount) {
    this.policyNumber = policyNumber;
    this.policyholderName = policyholderName;
    this.expiryDate = expiryDate;
    this.coverageType = coverageType;
    this.premiumAmount = premiumAmount;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public String getCoverageType() {
    return coverageType;
  }

  @Override
  public int compareTo(Policy other) {
    return this.expiryDate.compareTo(other.expiryDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Policy policy = (Policy) o;
    return Objects.equals(policyNumber, policy.policyNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyNumber);
  }

  @Override
  public String toString() {
    return "Policy{"
        + "policyNumber='"
        + policyNumber
        + '\''
        + ", policyholderName='"
        + policyholderName
        + '\''
        + ", expiryDate="
        + expiryDate
        + ", coverageType='"
        + coverageType
        + '\''
        + ", premiumAmount="
        + premiumAmount
        + '}';
  }
}

class PolicyManagementSystem {
  private Set<Policy> hashSet = new HashSet<>();
  private Set<Policy> linkedHashSet = new LinkedHashSet<>();
  private Set<Policy> treeSet = new TreeSet<>();

  public void addPolicy(Policy policy) {
    hashSet.add(policy);
    linkedHashSet.add(policy);
    treeSet.add(policy);
  }

  public void displayAllPolicies() {
    System.out.println("All Policies:");
    for (Policy policy : hashSet) {
      System.out.println(policy);
    }
  }

  public void displayExpiringSoon() {
    System.out.println("Policies Expiring Soon:");

    Date today = new Date();
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 30);
    Date threshold = cal.getTime();

    for (Policy policy : treeSet) {
      if (policy.getExpiryDate().before(threshold)) {
        System.out.println(policy);
      }
    }
  }

  public void displayByCoverageType(String coverageType) {
    System.out.println("Policies with coverage type: " + coverageType);
    for (Policy policy : hashSet) {
      if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
        System.out.println(policy);
      }
    }
  }

  public void findDuplicatePolicies() {
    System.out.println("Duplicate Policies:");
    Map<String, Integer> countMap = new HashMap<>();

    for (Policy policy : hashSet) {
      countMap.put(
          policy.getPolicyNumber(), countMap.getOrDefault(policy.getPolicyNumber(), 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() > 1) {
        System.out.println(
            "Policy Number: " + entry.getKey() + " (Duplicates: " + entry.getValue() + ")");
      }
    }
  }
}

public class InsuranceSystem {
  public static void main(String[] args) {
    PolicyManagementSystem system = new PolicyManagementSystem();
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 10);

    Date exp1 = cal.getTime();
    cal.add(Calendar.DAY_OF_YEAR, 40);

    Date exp2 = cal.getTime();
    Policy p1 = new Policy("P123", "Raj Jones", exp1, "Health", 5000.0);
    Policy p2 = new Policy("P124", "James Bond", exp2, "Auto", 1700.0);
    Policy p3 = new Policy("P125", "Thomas Shelby", exp1, "Home", 2900.0);

    system.addPolicy(p1);
    system.addPolicy(p2);
    system.addPolicy(p3);
    system.addPolicy(p1);
    system.displayAllPolicies();
    system.displayExpiringSoon();
    system.displayByCoverageType("Health");
    system.findDuplicatePolicies();
  }
}
