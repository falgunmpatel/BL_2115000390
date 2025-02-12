import java.util.*;

class FriendNode {
  int friendId;
  FriendNode next;

  public FriendNode(int friendId) {
    this.friendId = friendId;
    this.next = null;
  }
}

class UserNode {
  int userId;
  String name;
  int age;
  FriendNode friendList;
  UserNode next;

  public UserNode(int userId, String name, int age) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.friendList = null;
    this.next = null;
  }

  public void addFriend(int friendId) {
    FriendNode newFriend = new FriendNode(friendId);
    newFriend.next = friendList;
    friendList = newFriend;
  }

  public void removeFriend(int friendId) {
    if (friendList == null) return;
    if (friendList.friendId == friendId) {
      friendList = friendList.next;
      return;
    }

    FriendNode temp = friendList, prev = null;
    while (temp != null && temp.friendId != friendId) {
      prev = temp;
      temp = temp.next;
    }
    if (temp != null) prev.next = temp.next;
  }

  public boolean isFriend(int friendId) {
    FriendNode temp = friendList;
    while (temp != null) {
      if (temp.friendId == friendId) return true;
      temp = temp.next;
    }
    return false;
  }

  public int countFriends() {
    int count = 0;
    FriendNode temp = friendList;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  public void displayFriends() {
    if (friendList == null) {
      System.out.println(name + " has no friends.");
      return;
    }
    System.out.print(name + "'s friends: ");
    FriendNode temp = friendList;
    while (temp != null) {
      System.out.print(temp.friendId + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

class SocialMedia {
  private UserNode head;

  public void addUser(int userId, String name, int age) {
    if (findUserById(userId) != null) {
      System.out.println("User ID already exists!");
      return;
    }
    UserNode newUser = new UserNode(userId, name, age);
    newUser.next = head;
    head = newUser;
  }

  public UserNode findUserById(int userId) {
    UserNode temp = head;
    while (temp != null) {
      if (temp.userId == userId) return temp;
      temp = temp.next;
    }
    return null;
  }

  public UserNode findUserByName(String name) {
    UserNode temp = head;
    while (temp != null) {
      if (temp.name.equalsIgnoreCase(name)) return temp;
      temp = temp.next;
    }
    return null;
  }

  public void addFriendConnection(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found!");
      return;
    }
    if (user1.isFriend(userId2)) {
      System.out.println("They are already friends!");
      return;
    }
    user1.addFriend(userId2);
    user2.addFriend(userId1);
    System.out.println(user1.name + " and " + user2.name + " are now friends!");
  }

  public void removeFriendConnection(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found!");
      return;
    }
    if (!user1.isFriend(userId2)) {
      System.out.println("They are not friends!");
      return;
    }
    user1.removeFriend(userId2);
    user2.removeFriend(userId1);
    System.out.println("Friendship between " + user1.name + " and " + user2.name + " removed.");
  }

  public void findMutualFriends(int userId1, int userId2) {
    UserNode user1 = findUserById(userId1);
    UserNode user2 = findUserById(userId2);

    if (user1 == null || user2 == null) {
      System.out.println("One or both users not found!");
      return;
    }

    System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
    FriendNode temp1 = user1.friendList;
    boolean found = false;

    while (temp1 != null) {
      if (user2.isFriend(temp1.friendId)) {
        System.out.print(temp1.friendId + " ");
        found = true;
      }
      temp1 = temp1.next;
    }
    if (!found) System.out.print("None");
    System.out.println();
  }

  public void displayUserFriends(int userId) {
    UserNode user = findUserById(userId);
    if (user != null) {
      user.displayFriends();
    } else {
      System.out.println("User not found!");
    }
  }

  public void countFriends() {
    UserNode temp = head;
    while (temp != null) {
      System.out.println(temp.name + " has " + temp.countFriends() + " friends.");
      temp = temp.next;
    }
  }
}

public class SocialMediaFriend {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SocialMedia sm = new SocialMedia();

    while (true) {
      System.out.println("\nSocial Media Friend Connections");
      System.out.println("1. Add User");
      System.out.println("2. Add Friend Connection");
      System.out.println("3. Remove Friend Connection");
      System.out.println("4. Find Mutual Friends");
      System.out.println("5. Display Friends of a User");
      System.out.println("6. Search User by Name or ID");
      System.out.println("7. Count Friends of Each User");
      System.out.println("8. Exit");
      System.out.print("Enter choice: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter User ID: ");
          int id = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Name: ");
          String name = scanner.nextLine();
          System.out.print("Enter Age: ");
          int age = scanner.nextInt();
          sm.addUser(id, name, age);
          break;
        case 2:
          System.out.print("Enter first User ID: ");
          int u1 = scanner.nextInt();
          System.out.print("Enter second User ID: ");
          int u2 = scanner.nextInt();
          sm.addFriendConnection(u1, u2);
          break;
        case 3:
          System.out.print("Enter first User ID: ");
          u1 = scanner.nextInt();
          System.out.print("Enter second User ID: ");
          u2 = scanner.nextInt();
          sm.removeFriendConnection(u1, u2);
          break;
        case 4:
          System.out.print("Enter first User ID: ");
          u1 = scanner.nextInt();
          System.out.print("Enter second User ID: ");
          u2 = scanner.nextInt();
          sm.findMutualFriends(u1, u2);
          break;
        case 5:
          System.out.print("Enter User ID: ");
          int uid = scanner.nextInt();
          sm.displayUserFriends(uid);
          break;
        case 6:
          System.out.print("Enter User ID: ");
          int searchId = scanner.nextInt();
          sm.findUserById(searchId);
          break;
        case 7:
          sm.countFriends();
          break;
        case 8:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice!");
      }
    }
  }
}
