# Scriptrunner Web Panel Example

This folder contains a sample Groovy script for an Atlassian Scriptrunner Web Panel.
The script `web-panel.groovy` renders Jira *wiki markup* inside a panel using Atlassian's
AUI CSS classes. Wiki text is converted to HTML using Jira's built-in renderer
so no additional dependencies are required.

Add this script when configuring a Web Panel through **Script Fragments** in
Scriptrunner and the panel will display formatted wiki content.
