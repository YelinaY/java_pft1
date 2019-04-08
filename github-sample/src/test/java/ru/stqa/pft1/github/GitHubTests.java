package ru.stqa.pft1.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

    @Test
    public void testCommits() throws IOException {

        Github github = new RtGithub("c589523b36325c38505721a069c63a94dc7c0f26");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("YelinaY", "java_pft1")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
        System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}