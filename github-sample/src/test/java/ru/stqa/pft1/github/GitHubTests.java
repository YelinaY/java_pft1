package ru.stqa.pft1.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

    @Test
    public void testCommits() throws IOException {

        Github github = new RtGithub("07449eab920086f4641981cc3e5f0a327afadc01");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("YelinaY", "java_pft1")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
        System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}