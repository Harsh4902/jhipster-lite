package tech.jhipster.lite.generator.githubactions.infrastructure.primary.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.lite.generator.githubactions.application.GithubActionsApplicationService;
import tech.jhipster.lite.generator.project.domain.Project;
import tech.jhipster.lite.generator.project.infrastructure.primary.dto.ProjectDTO;
import tech.jhipster.lite.technical.infrastructure.primary.annotation.GeneratorStep;

@RestController
@RequestMapping("/api/github-actions/")
@Tag(name = "Github Actions")
class GithubActionsResource {

  private final GithubActionsApplicationService githubActionsApplicationService;

  GithubActionsResource(GithubActionsApplicationService githubActionsApplicationService) {
    this.githubActionsApplicationService = githubActionsApplicationService;
  }

  @Operation(summary = "Init Github Actions YML file")
  @ApiResponse(responseCode = "500", description = "An error occurred while initializing the github-actions.yml.mustache file")
  @PostMapping("/init")
  @GeneratorStep(id = "init")
  public void init(@RequestBody ProjectDTO projectDTO) {
    Project project = ProjectDTO.toProject(projectDTO);
    githubActionsApplicationService.init(project);
  }
}
