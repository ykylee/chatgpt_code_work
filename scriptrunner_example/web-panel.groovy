import com.atlassian.sal.api.component.ComponentLocator
import com.atlassian.webresource.api.assembler.PageBuilderService
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

// Require Atlassian AUI resources so the panel uses the default styling
PageBuilderService pageBuilderService = ComponentLocator.getComponent(PageBuilderService)
pageBuilderService.assembler().resources().requireWebResource("com.atlassian.auiplugin:aui-css")

// Markdown text to display in the panel
String markdownText = """
# Sample Web Panel

This panel is rendered from **Markdown** using the CommonMark parser.

* Item 1
* Item 2
"""

Parser parser = Parser.builder().build()
HtmlRenderer renderer = HtmlRenderer.builder().build()
String htmlContent = renderer.render(parser.parse(markdownText))

return """
<div class='aui-page-panel'>
  <section class='aui-page-panel-content'>
    ${htmlContent}
  </section>
</div>
"""
