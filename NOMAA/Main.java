import java.util.ArrayList;
import java.util.List;

// Document class
class Document {
    private String id;
    private String name;
    private String content;
    private List<String> versions;

    public Document(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.versions = new ArrayList<>();
    }

    public void addVersion(String version) {
        this.versions.add(version);
    }

    public void updateContent(String newContent) {
        this.versions.add(this.content);  // store the current content as a version
        this.content = newContent;  // update to new content
    }

    public List<String> getVersions() {
        return this.versions;
    }

    public String getName() {
        return this.name;
    }
}

// User class
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// Document Management System class
class DMS {
    private List<Document> documents;
    private List<User> users;

    public DMS() {
        this.documents = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<Document> searchDocuments(String keyword) {
        List<Document> results = new ArrayList<>();
        for (Document document : this.documents) {
            if (document.getName().contains(keyword)) {
                results.add(document);
            }
        }
        return results;
    }

    public boolean hasAccess(User user, Document document) {
        // Implement access permission logic here
        return true; // for simplicity
    }

    public void updateDocument(User user, Document document, String newContent) {
        if (hasAccess(user, document)) {
            document.updateContent(newContent);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DMS dms = new DMS();

        // create users
        User admin = new User("admin", "password");
        User user1 = new User("user1", "password");

        // create documents
        Document doc1 = new Document("1", "Land Title", "This is a land title document");
        Document doc2 = new Document("2", "Land Survey", "This is a land survey document");

        // add users and documents to DMS
        dms.addUser(admin);
        dms.addUser(user1);
        dms.addDocument(doc1);
        dms.addDocument(doc2);

        // search for documents
        List<Document> results = dms.searchDocuments("Land");
        for (Document document : results) {
            System.out.println(document.getName());
        }

        // update document
        dms.updateDocument(admin, doc1, "This is an updated land title document");

        // print document versions
        for (String version : doc1.getVersions()) {
            System.out.println(version);
        }
    }
}
