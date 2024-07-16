<link rel="stylesheet" type="text/css" href="styles.css">
// view_users.php
<?php
include 'db.php';

$sql = "SELECT * FROM users";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<h2>Users List</h2>";
    echo "<table border='1'>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>";
    while ($row = $result->fetch_assoc()) {
        echo "<tr>
                <td>" . $row['id'] . "</td>
                <td>" . $row['name'] . "</td>
                <td>" . $row['email'] . "</td>
                <td>
                    <a href='edit_user.php?id=" . $row['id'] . "'>Edit</a> | 
                    <a href='delete_user.php?id=" . $row['id'] . "' onclick=\"return confirm('Are you sure you want to delete this user?');\">Delete</a>
                </td>
              </tr>";
    }
    echo "</table>";
} else {
    echo "No users found";
}

$conn->close();
?>
