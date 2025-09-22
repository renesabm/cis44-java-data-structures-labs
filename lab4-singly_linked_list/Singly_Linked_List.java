/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_4;

/**
 *
 * @author panka
 */
public class Singly_Linked_List {

    public class Song {
    String title;
    String artist;
    // Constructor and getters...
        public Song(String title, String artist) {
        this.title=title;
        this.artist=artist;
        }
        public String getTitle() {
        return title;
        }
        public String getArtist() {
        return artist;
        }
    }

    public class Playlist {
        private static class Node {
            Song song;
            Node next;
            // Node constructor...
            public Node(Song song, Node next) {
                this.song=song;
                this.next=next;
            }
            public void setNext(Node next) {
                this.next=next;
            }
            public void setArtist(Song song) {
                this.song=song;
            }


        }

        private Node head;
        private Node tail;
        private Node currentNode;
        private int size;

        public Playlist() {
            this.head = null;
            this.tail = null;
            this.currentNode = null;
            this.size = 0;
        }
        public boolean isEmpty() {
            return size==0;
        }

        public void addSong(Song song) {
            // Your implementation here...
            Node newNode=new Node(song,null);
            if (isEmpty()) {
                head=newNode;
            }
            else {
                tail.setNext(newNode);
            }
            tail= newNode;
            size++;

        }

        public void removeSong(String title) {
            // Handle two cases: removing the head and removing from elsewhere.
            // Don't forget to update the tail if the last song is removed.
            if (isEmpty()) {
                System.out.println("Playlist is already empty");
                return;
            }
            Node current=head;
            Node previous=null;
            boolean not_found = false;

            while (current!=null) {
                if (current.song.getTitle().equalsIgnoreCase(title)) {
                    if (previous==null) {
                    head=current.next;
                    }
                    else {
                        previous.setNext(current.next);
                    }

                    if (current==tail) {
                        tail=previous;
                    }

                    if (current==currentNode) {
                        if (currentNode!=null) {
                            currentNode=current.next;
                        }
                        else {
                            currentNode=head;
                        }
                    }

                size--;
                System.out.println("Removed: " +current.song.getTitle());
                break;
                }

                previous=current;
                current=current.next;
                if (not_found) {
                System.out.println("Song not found");
                }

            }
        }

        public void playNext() {
            // If currentNode is null, start from the head.
            // Otherwise, advance to the next node.
            // If you reach the end, loop back to the head.
            if (isEmpty()) {
                System.out.println("Playlist is empty");
            }
            if (currentNode==null) {
                currentNode=head;
            }
            else {
                currentNode=currentNode.next;
                if (currentNode==null) {
                    currentNode=head;
                }
            }
            System.out.println("Currently playing: "+currentNode.song.getTitle());
        }

        public void displayPlaylist() {
            // Traverse from the head and print each song.
            if (isEmpty()) {
                System.out.println("Playlist is empty");
            }
            Node current=head;
            System.out.println("Playlist:");
            while (current!=null) {
                System.out.println(current.song.getTitle()+ " by " + current.song.getArtist());
                current=current.next;
            }
        }
    }
    public static void main(String[] args) {
        Singly_Linked_List list = new Singly_Linked_List();
        Singly_Linked_List.Playlist playlist = list.new Playlist();
        Singly_Linked_List.Song song1 = list.new Song("this is me trying", "Taylor Swift");
        Singly_Linked_List.Song song2 = list.new Song("Firework", "Katy Perry");
        Singly_Linked_List.Song song3 = list.new Song("Let it Be", "The Beatles");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.displayPlaylist();
        playlist.playNext();
        playlist.playNext();
        playlist.playNext();
        playlist.removeSong("Firework");
        playlist.displayPlaylist();
    }
}

