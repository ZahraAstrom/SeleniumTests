# Tumblr Tests

List of Tests:
* [Log In](#login)
* [Create Text Post](#createTextPost)
* [Reblog Post](#reblogPost)
* [Dashboard Dynamic Scroll](#dashboardDynamicScroll)
* [Notes Above 1000](#notesAboveGrand)
* [Top 5 Notes](#topFiveNotes)
* [Top 5 of N](#topFiveOfN)
* [Top Notes of Titled Posts](#topNotesOfTitledPosts)

#### <a name="login"></a>Log In

Logged in. It was great. There were buttons and some keys - good times.

#### <a name="createTextPost"></a>Create Text Post

* ##### Objective:
    Tumblr allows people to create posts and submit it. This should apply to the dashboard for the user and all their followers to see.

* ##### Technical Approach:
    The challenge lay in creating a unique post so that the assertion would not result in false-positives. To do this, I created a for loop that generated a random string from an array of characters and placed the string in the title, body and tag fields of the post. I asserted the specific random string was present in each field to conclude the test.

#### <a name="reblogPost"></a>Reblog post

* ##### Objective:
    Another feature of tumblr is the ability to "reblog" a post. 
* ##### Technical Approach:
    I did this in a similar way to the previous test, generating a random string, adding it as a comment to the reblogged post, and asserting it was present. Hooray for iterative testing!

#### <a name="dashboardDynamicScroll"></a>Dashboard Dynamic Scroll

* ##### Objective:
    Tumblr allows you to scroll 'infinitely' through content on your dashboard via a dynamic scrolling feature. 
* ##### Technical Approach:
    To test this, I created a scroll Action that would move to the last element of a list. I then applied this to a while loop that would continue to scroll until n number of elements existed in the list.

#### <a name="notesAboveGrand"></a>Notes Above 1000

* ##### Objective:
    This was a datascraping challenge for myself. The objective was to look at the initially loaded posts and add any with at least 1000 notes to a list. 
* ##### Technical Approach:
    I did this by creating a for loop that iterated over a list of webelements, pulled the number of notes from it, parsed the number from string to integer and added it to a list if the number was greater than 1000. I then sorted the list in descending order and assered that each number in the list was lower than the one before it but still greater than 1000.

#### <a name="topFiveNotes"></a>Top 5 Notes

* ##### Objective:
    Another data scrape. 
* ##### Technical Approach
    This was almost the same as the previous data scrape but only returned a sublist of the top 5 highest notes. Unlike the previous test, the notes were not recquired to be over any number.

#### <a name="topFiveOfN"></a>Top 5 of N
* ##### Objective:
    This data scrape involved the same as the previous test but included the scroll Action I used to test the dynamic scrolling on the dashboard. 
* ##### Technical Approach:
    I did this by creating a for loop, and iterating over the posts until the required amount of posts was met. In the loop, I would pull the number of notes from the webelement, parse it into an integer and add it to a list. I then ordered the list in descending order as I had done in previous tests.

#### <a name="topNotesOfTitledPosts"></a>Top Notes of Titled Posts
* ##### Objective:
    This final data scrape I performed on tumblr.com involves two dimensional data. 
* ##### Technical Approacth:
    It involves a for loop that looks all post web elements, checks if the post has a title field, and if it does, it pulls the title and the number of notes and adds it to a string list. I then added the list containing the title and note number to another list (is the word "list" sounding weird to you?). Next, I ordered it using collections.sort. I provided it with a custom comparator that overrode the compare method. The override compared the second index of the list (the note number) and parsed it to an integer.
