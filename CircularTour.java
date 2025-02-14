class CircularTour {
  public static int findStartingPoint(int[] petrol, int[] distance) {
    int n = petrol.length;
    int start = 0, totalPetrol = 0, deficit = 0;
    for (int i = 0; i < n; i++) {
      totalPetrol += petrol[i] - distance[i];
      if (totalPetrol < 0) {
        deficit += totalPetrol;
        start = i + 1;
        totalPetrol = 0;
      }
    }

    return (totalPetrol + deficit >= 0) ? start : -1;
  }

  public static void main(String[] args) {
    int[] petrol = {4, 6, 7, 4};
    int[] distance = {6, 5, 3, 5};
    int startIndex = findStartingPoint(petrol, distance);
    System.out.println("Starting petrol pump index: " + startIndex);
  }
}
