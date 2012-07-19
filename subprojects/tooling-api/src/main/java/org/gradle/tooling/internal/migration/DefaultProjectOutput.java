/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.tooling.internal.migration;

import com.google.common.collect.Lists;
import org.gradle.tooling.internal.protocol.InternalProjectOutput;
import org.gradle.tooling.model.DomainObjectSet;
import org.gradle.tooling.model.internal.ImmutableDomainObjectSet;
import org.gradle.tooling.model.migration.ProjectOutput;
import org.gradle.tooling.model.migration.TaskOutput;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class DefaultProjectOutput implements InternalProjectOutput, ProjectOutput, Serializable {
    private final String name;
    private final ProjectOutput parent;
    private final List<ProjectOutput> children = Lists.newArrayList();
    private final Set<TaskOutput> taskOutputs;

    public DefaultProjectOutput(String name, ProjectOutput parent, Set<TaskOutput> taskOutputs) {
        this.name = name;
        this.taskOutputs = taskOutputs;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return null;
    }

    public ProjectOutput getParent() {
        return parent;
    }

    public DomainObjectSet<ProjectOutput> getChildren() {
        return new ImmutableDomainObjectSet<ProjectOutput>(children);
    }

    public Set<TaskOutput> getTaskOutputs() {
        return taskOutputs;
    }

    public String getPath() {
        throw new UnsupportedOperationException("getPath");
    }

    public File getProjectDirectory() {
        throw new UnsupportedOperationException("getProjectDirectory");
    }

    public void addChild(ProjectOutput child) {
        children.add(child);
    }
}
