import com.atlassian.sal.api.component.ComponentLocator
import com.atlassian.webresource.api.assembler.PageBuilderService

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.fields.renderer.RendererManager

// Require Atlassian AUI resources so the panel uses the default styling
PageBuilderService pageBuilderService = ComponentLocator.getComponent(PageBuilderService)
pageBuilderService.assembler().resources().requireWebResource("com.atlassian.auiplugin:aui-css")

// Wiki markup text to display in the panel
String wikiText = """
h1. Sample Web Panel

This panel is rendered from *Jira* wiki syntax.

* Item 1
* Item 2
"""

RendererManager rendererManager = ComponentAccessor.getComponent(RendererManager)
String htmlContent = rendererManager.getRendererForType("atlassian-wiki-renderer").render(wikiText, null)

writer.write """
<div class='aui-page-panel'>
  <section class='aui-page-panel-content'>
    ${htmlContent}
  </section>
</div>
"""
