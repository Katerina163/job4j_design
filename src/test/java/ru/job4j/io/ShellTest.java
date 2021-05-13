package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd("/user");
        shell.cd("../root");
        assertThat(
                shell.pwd(), is("/root")
        );
    }

    @Test
    public void whenAbsolutePath() {
        Shell shell = new Shell();
        shell.cd("/path/to/file");
        shell.cd("/new/path/to/my/file");
        assertThat(shell.pwd(), is("/new/path/to/my/file"));
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenTwoCd() {
        Shell shell = new Shell();
        shell.cd("path/to");
        shell.cd("dir/file");
        assertThat(
                shell.pwd(), is("/path/to/dir/file")
        );
    }

    @Test
    public void whenCdWithSeparator() {
        Shell shell = new Shell();
        shell.cd("path/to");
        shell.cd("/dir/file");
        assertThat(
                shell.pwd(), is("/dir/file")
        );
    }

    @Test
    public void whenCdBackTwo() {
        Shell shell = new Shell();
        shell.cd("path/to");
        shell.cd("../../dir/file");
        assertThat(
                shell.pwd(), is("/dir/file")
        );
    }
}