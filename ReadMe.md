# QuizIT app- CTF Tech Task
A quiz App designed based on the specifications laid down for the CTF Tech task complete with registration, timer and a leaderboard. <br />
I have included comments to describe the functionality in most places. <br />
Since this uses SQLite, one has to register in the beginning, as per the task specification.<br />
There are two kinds of quizes - Tech & Cricket. Each genre has 5 questions and 50 seconds for each quiz. <br />
One can see the leaderboard which has top three scores with the username. <br />
I have attached the apk in the QuizIt app folder.

## Prerequisites
```
minSdkVersion 22
```
```
targetSdkVersion 27
```
## Used
 * SQLite- For Login and Register
 * Shared Preferences - For maintaining leaderboard

## Screenshots
Login activity which uses SQLite<br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/login.jpg" alt="login" width="200" height="300">
<br />
Register Activity <br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/register.jpg" alt="register" width="200" height="300">
<br />
Dashboard<br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/dashboard.jpg" alt="dashboard" width="200" height="300">
<br />
Quiz Question Activity<br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/question.jpg" alt="dashboard" width="200" height="300">
<br />
Leaderboard<br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/leaderboard.jpg" alt="leaderboard" width="200" height="300">
<br />
Result Screen<br />
<img src="https://github.com/bhargav191098/Quiz_Tech_Task/blob/master/ctf_screenshot/yourscore.jpg" alt="result" width="200" height="300">
<br />
## Resources <br />
   * Created the dashboard and the login screen font using the following website:
      ```
      https://fontmeme.com/calligraphy-fonts/
      ```
   * Designed the buttons using the following website:
      ```
      http://angrytools.com/android/button/
      ```
   * For the ReadMe.md file, refer to this wonderful gist!
      ```
      https://gist.github.com/PurpleBooth/109311bb0361f32d87a2
      ```
   * The progress bar for the quiz 
      ```
      https://github.com/lzyzsd/CircleProgress
      ```
      Use this by adding the following in your build.grade(app level) file
      ```
      compile 'com.github.lzyzsd:circleprogress:1.1.0@aar'
      ```
   
