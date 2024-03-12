<%-- 
    Document   : addques
    Created on : Mar 5, 2024, 8:14:59 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create a Question</title>
            <style>
                /* Styles for form layout */
                body {
                    font-family: Arial, sans-serif;
                }
                .form-container {
                    max-width: 600px;
                    margin: 0 auto;
                    padding: 20px;
                    background-color: #f9f9f9;
                    border-radius: 8px;
                }
                .form-group {
                    margin-bottom: 20px;
                }
                .form-group label {
                    font-weight: bold;
                }
                .form-group input[type="text"] {
                    width: 100%;
                    padding: 8px;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                }
                .add-option {
                    color: #4285f4;
                    text-decoration: underline;
                    cursor: pointer;
                }
            </style>
        </head>
        <body>
            <div class="form-container">
                <h2>Create a Question</h2>
                <form action="addques" method="POST">
                    <div class="form-group">
                        <label for="content">Content: </label>
                        <input type="text" id="quescontent" name="quescontent" placeholder="Enter your Content" required>
                    </div>
                    <div class="form-group">
                        <label for="explain">Explain: </label>
                        <input type="text" id="quesexplain" name="quesexplain" placeholder="Enter your Explain" required>
                    </div>

                    <label for="subjects">Choose a subject:</label>
                    <input list="subjects" name="subject" id="subject">
                    <datalist id="subjects">
                        <c:forEach items="${requestScope.sublist}" var="ba">
                            <option value="${ba.subjectName}" >
                            </c:forEach>
                    </datalist>
                    <div id="options">
                        <div class="option">
                            <label for="option1">Option 1:</label>
                            <input type="text" class="option-text" name="option[]" required>
                            <input type="checkbox" class="correct-checkbox" name="correct[]" value="1">
                            <label for="correct1">Correct</label><br>
                        </div>
                    </div>

                    <button type="button" onclick="addOption()">Add Option</button><br><br>

                    <input type="submit" value="Submit">
                </form>

                <script>
                    function addOption() {
                        var optionsDiv = document.getElementById('options');
                        var optionCount = optionsDiv.getElementsByClassName('option').length + 1;

                        var newOptionDiv = document.createElement('div');
                        newOptionDiv.className = 'option';

                        var optionLabel = document.createElement('label');
                        optionLabel.htmlFor = 'option' + optionCount;
                        optionLabel.textContent = 'Option ' + optionCount + ':';
                        newOptionDiv.appendChild(optionLabel);

                        var optionInput = document.createElement('input');
                        optionInput.type = 'text';
                        optionInput.className = 'option-text';
                        optionInput.name = 'option[]';
                        optionInput.required = true;
                        newOptionDiv.appendChild(optionInput);

                        var correctCheckbox = document.createElement('input');
                        correctCheckbox.type = 'checkbox';
                        correctCheckbox.className = 'correct-checkbox';
                        correctCheckbox.name = 'correct[]';
                        correctCheckbox.value = optionCount;
                        newOptionDiv.appendChild(correctCheckbox);

                        var correctLabel = document.createElement('label');
                        correctLabel.htmlFor = 'correct' + optionCount;
                        correctLabel.textContent = 'Correct';
                        newOptionDiv.appendChild(correctLabel);

                        optionsDiv.appendChild(newOptionDiv);
                    }
                </script>
        </body>
    </html>
