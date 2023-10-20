/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.atlas.job.repository.jdbc;

import com.bytechef.atlas.domain.Workflow;
import com.bytechef.atlas.job.repository.jdbc.config.WorkflowRepositoryIntTestConfiguration;
import com.bytechef.atlas.repository.WorkflowRepository;
import com.bytechef.atlas.workflow.WorkflowFormat;
import com.bytechef.test.extension.PostgresTestContainerExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ivica Cardic
 */
@ExtendWith(PostgresTestContainerExtension.class)
@SpringBootTest(
        classes = WorkflowRepositoryIntTestConfiguration.class,
        properties = "bytechef.workflow.workflow-repository.jdbc.enabled=true")
public class JdbcWorkflowRepositoryIntTest {

    @Autowired
    private WorkflowRepository workflowRepository;

    @Test
    public void testFindById() {
        Workflow workflow = new Workflow();

        workflow.setDefinition(
                """
            label: My Label

            tasks:
              - name: stringNumber
                type: var/1.0
                action: set
                value: "1234"
            """);
        workflow.setFormat(WorkflowFormat.YAML);

        workflow = workflowRepository.save(workflow);

        Workflow resultWorkflow = workflowRepository.findById(workflow.getId()).orElseThrow();

        Assertions.assertEquals("My Label", resultWorkflow.getLabel());
        Assertions.assertEquals(1, resultWorkflow.getTasks().size());
    }
}
